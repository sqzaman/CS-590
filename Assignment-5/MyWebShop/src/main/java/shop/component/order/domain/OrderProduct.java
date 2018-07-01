package shop.component.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderProduct {
	String productNumber;
	String name;
	double price;

	public OrderProduct(String productNumber, String name, double price) {
		this.productNumber = productNumber;
		this.price = price;
		this.name = name;
	}

	public OrderProduct() {
	}
	public String getProductNumber() {
		return productNumber;
	}

	public void setProducNumber(String productNumber) {
		this.productNumber = productNumber;
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
