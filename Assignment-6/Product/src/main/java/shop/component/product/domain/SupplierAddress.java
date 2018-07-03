package shop.component.product.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SupplierAddress {
	String street;
	String city;
	String zip;
	String country;

	public SupplierAddress(String street, String city, String zip, String country) {
		this.street = street;
		this.city = city;
		this.zip = zip;
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

	public String getCountry() {
		return country;
	}


}
