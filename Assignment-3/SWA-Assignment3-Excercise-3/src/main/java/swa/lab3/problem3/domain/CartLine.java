package swa.lab3.problem3.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CartLine {
	Product product;
	int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
