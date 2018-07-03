package shop.component.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.component.shopping.domain.ShoppingCart;


public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String>  {

}
