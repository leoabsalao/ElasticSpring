package br.com.absalao.elastic.springboot.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.absalao.elastic.springboot.document.Product;
import br.com.absalao.elastic.springboot.document.Product.ProductBuilder;
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

    // Se existir o dacumento atualiza, senão, cria um novo documento.
    @Override
    public void updateProduct(Product product, String id) {
        Product newProduct = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quant(product.getQuant())
                .id(product.getId())
                .build();

        productRepository.save(newProduct);
    }

    @Override
    public void deleteProduct(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Product findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Iterable<Product> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<Product> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }
    
}
