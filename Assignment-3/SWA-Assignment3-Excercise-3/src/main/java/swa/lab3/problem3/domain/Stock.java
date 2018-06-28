package swa.lab3.problem3.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
	String locationCode;
	int quantity;
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
