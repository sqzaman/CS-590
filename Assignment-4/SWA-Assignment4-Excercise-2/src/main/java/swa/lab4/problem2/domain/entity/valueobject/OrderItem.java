package swa.lab4.problem2.domain.entity.valueobject;

public class OrderItem {
	private String productId;
	private int quantity;
	public OrderItem(String productId, int quantity) {
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
