package br.com.absalao.elastic.springboot.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.absalao.elastic.springboot.document.Product;
import br.com.absalao.elastic.springboot.repository.ProductRepository;
import br.com.absalao.elastic.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product, String id) {
        Product newProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
            newProduct.setName(product.getName());
            newProduct.setDescription(product.getDescription());
            newProduct.setPrice(product.getPrice());
            newProduct.setQuant(product.getQuant());

            productRepository.save(newProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.findById(id).orElseThrow(RuntimeException::new);
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findByName(String name) {
       return productRepository.findByContainName(name, PageRequest.of(0, 1));
    }
    
}
