package br.com.absalao.elastic.springboot.service;

import org.springframework.data.domain.Page;
import br.com.absalao.elastic.springboot.document.Product;


public interface ProductService {
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String id);
    Product findById(String id);
    Iterable<Product> findAll();
    Page<Product> findByName(String name);
}
