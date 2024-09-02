package br.com.absalao.elastic.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.absalao.elastic.springboot.document.Product;


public interface ProductRepository extends ElasticsearchRepository<Product, String>{    
    Page<Product> findByName(String name, Pageable pageable);
}
