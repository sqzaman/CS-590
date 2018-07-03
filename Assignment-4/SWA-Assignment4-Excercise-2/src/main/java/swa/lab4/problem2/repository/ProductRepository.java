package swa.lab4.problem2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import swa.lab4.problem2.domain.entity.Product;


public interface ProductRepository extends MongoRepository<Product, String>  {

}
