package swa.lab4.problem2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import swa.lab4.problem2.domain.entity.ShoppingCart;


public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String>  {

}
