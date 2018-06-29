package swa.lab4.problem2.domain.entity.valueobject;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
final public class Stock {

	private String locationCode;
	private int quantity;
	

	public Stock(String locationCode, int quantity) {

		this.locationCode = locationCode;
		this.quantity = quantity;
	}	
	
	public String getLocationCode() {
		return locationCode;
	}

	public int getQuantity() {
		return quantity;
	}


}
