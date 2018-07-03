package shop.component.customer.service;

import java.time.LocalDate;
import java.util.List;

import shop.component.customer.domain.Customer;

public interface ICustomer {
	public void addCustomer(String customerId, String firstName, String lastName, String email, String phone);
	public Customer getCustomer(String customerId);
	public List<Customer> getAllCustomer();	
	public void addCreditCard(String customerId, String cardName, String cardNumber, LocalDate validTill);
	public void addBillingAddress(String customerId, String street, String city, String zip, String state, String country);
	public void addShippingAddress(String customerId, String street, String city, String zip, String state, String country);
}
