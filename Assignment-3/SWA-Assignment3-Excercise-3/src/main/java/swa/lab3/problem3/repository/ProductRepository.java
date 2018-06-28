package swa.lab3.problem3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import swa.lab3.problem3.domain.Product;
import swa.lab3.problem3.domain.ShoppingCart;

public interface ProductRepository extends MongoRepository<Product, String>  {

}
