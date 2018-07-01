package shop.component.shopping.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Product {
	
	@Id
	String productId;
	String name;
	double price;

	public Product(String productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("Product Id:%s, Name:%s, Price:%", productId, name, price);
	}
}
