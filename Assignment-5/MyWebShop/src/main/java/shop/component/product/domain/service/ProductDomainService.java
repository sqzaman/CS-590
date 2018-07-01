package shop.component.product.domain.service;

import org.springframework.stereotype.Service;

import shop.component.product.domain.Product;
import shop.component.product.domain.Stock;

@Service
public class ProductDomainService {
	public Product createProduct(String productId, String name, String description, double price) {
		return new Product(productId, name, description, price);
	}
	public void setStock(Product product, String locationCode, int quantity) {
		product.setStock(new Stock(locationCode, quantity));
	}
}
