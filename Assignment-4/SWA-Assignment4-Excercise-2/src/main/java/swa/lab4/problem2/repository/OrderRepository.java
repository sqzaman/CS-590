package swa.lab4.problem2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.Product;




public interface OrderRepository extends MongoRepository<Order, String>  {

}
