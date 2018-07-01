package shop.component.customer.domain.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document
public class Customer {
	@Id
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private CustomerAddress billingAddress;
	private CustomerAddress shippingAddress;
	//@JsonIgnore
	private List<CreditCard> creditCards;
	public Customer() {
		
	}
	public Customer(String customerId, String firstName, String lastName, String email, String phone) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.creditCards = new ArrayList<CreditCard>();
	}
	public Customer(String customerId, String firstName, String lastName, String email, String phone,
			CustomerAddress billingAddress, CustomerAddress shippingAddress) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.creditCards = new ArrayList<CreditCard>();
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

	public CustomerAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(CustomerAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public CustomerAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(CustomerAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void addCreditCard(CreditCard creditCard) {
		this.creditCards.add(creditCard);
	}

}
