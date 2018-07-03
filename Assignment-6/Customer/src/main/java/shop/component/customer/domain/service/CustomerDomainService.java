package shop.component.customer.domain.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import shop.component.customer.domain.CreditCard;
import shop.component.customer.domain.Customer;
import shop.component.customer.domain.CustomerAddress;

@Service
public class CustomerDomainService {
	public enum AddressType{
		BillingAddress, ShippingAddres
	}

	public Customer createCustomer(String customerId, String firstName, String lastName, String email, String phone) {
		return new Customer(customerId, firstName, lastName, email, phone);
	}
	
	public void createAndAddCreditCardToCustomer(Customer customer, String cardName, String cardNumber, LocalDate validTill) {
		CreditCard creditCard = new CreditCard(cardName, cardNumber, validTill);
		customer.addCreditCard(creditCard);
	}
	
	public void createAndAddAddressToCustomer(Customer customer, String street, String city, String zip, String state, String country, AddressType addressType) {
		if(addressType == AddressType.BillingAddress) {
			customer.setBillingAddress(new CustomerAddress(street, city, zip, state, country));
		} else if(addressType == AddressType.ShippingAddres) {
			customer.setShippingAddress(new CustomerAddress(street, city, zip, state, country));
		}
	}
}
