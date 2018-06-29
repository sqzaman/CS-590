package swa.lab4.problem2.domain.entity.valueobject;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
final public class CartItem {
	private String productId;
	private int quantity;	
	
	public CartItem(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}	
}
