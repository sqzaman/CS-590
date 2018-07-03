package shop.component.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.component.product.domain.Supplier;


public interface SupplierRepository extends MongoRepository<Supplier, String>  {

}
