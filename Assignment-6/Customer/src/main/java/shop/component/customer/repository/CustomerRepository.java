package shop.component.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.component.customer.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>  {

}
