package shop.component.order.reository;

import org.springframework.data.mongodb.repository.MongoRepository;


import shop.component.order.domain.Order;

public interface OrderRepository extends MongoRepository<Order, String>  {

}

