package shop.component.customer.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderAddressDto {
	String street;
	String city;
	String zip;
	String state;
	String country;
	public OrderAddressDto(String street, String city, String zip, String state, String country) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	
}
