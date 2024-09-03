package br.com.absalao.elastic.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.absalao.elastic.springboot.document.Product;
import br.com.absalao.elastic.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Product product) {
        productService.createProduct(product);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/id/{id}")
    public void update(@RequestBody Product product, @PathVariable String id) {
        productService.updateProduct(product, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name/{name}")
    public Page<Product> findByName(@PathVariable String name) {
        return productService.findByContainsName(name);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public Product findById(@PathVariable String id) {
       return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<Product> getAll(){
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/id/{id}")
    public void delete(String id){
        productService.deleteProduct(id);
    }
}
