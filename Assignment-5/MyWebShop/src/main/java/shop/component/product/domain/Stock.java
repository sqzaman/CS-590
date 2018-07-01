package shop.component.product.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
	String locationcode;
	int quantity;
	
	public Stock(String locationcode, int quantity) {
		this.locationcode = locationcode;
		this.quantity = quantity;
	}
	
	public String getLocationcode() {
		return locationcode;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return String.format("Lcation code:%s, Quantity:%s", locationcode, quantity);
	}

}
