package shop.component.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderCustomer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public OrderCustomer() {
		
	}
	public OrderCustomer(String customerId, String firstName, String lastName, String email, String phone) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
