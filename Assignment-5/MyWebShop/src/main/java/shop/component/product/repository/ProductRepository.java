package shop.component.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.component.product.domain.Product;


public interface ProductRepository extends MongoRepository<Product, String>  {

}
