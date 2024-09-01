package br.com.absalao.elastic.springboot.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.absalao.elastic.springboot.document.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String>{    
}
