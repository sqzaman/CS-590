package shop.component.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderProduct {
	String productId;
	String name;
	double price;

	public OrderProduct(String productId, String name, double price) {
		this.productId = productId;
		this.price = price;
		this.name = name;
	}

	public OrderProduct() {
	}
	public String getProductId() {
		return productId;
	}

	public void setProducId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
