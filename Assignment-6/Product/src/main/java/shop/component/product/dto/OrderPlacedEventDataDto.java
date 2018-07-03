package shop.component.product.dto;

import java.util.HashMap;
import java.util.Map;

public class OrderPlacedEventDataDto {
	String customerId;
	private String orderId;
	private Map<String, Integer> productList;
	public OrderPlacedEventDataDto() {
		
	}
	public OrderPlacedEventDataDto(String customerId, String orderId) {
		this.customerId = customerId;
		this.orderId = orderId;
		this.productList = new HashMap<String, Integer>();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Map<String, Integer> getProductList() {
		return productList;
	}
	public void addProductToList(String productId, int quantity) {
		this.productList.put(productId, quantity);
	}
	
	
	


	

}
