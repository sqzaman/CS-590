package shop.component.customer.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import shop.component.customer.domain.customer.Customer;
import shop.component.customer.domain.service.CustomerDomainService;
import shop.component.customer.domain.service.CustomerDomainService.AddressType;
import shop.component.customer.repository.CustomerRepository;
import shop.component.customer.service.ICustomer;
import shop.event.OrderEventData;

@Service
public class CustomerService implements ICustomer {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerDomainService customerDomainService;

	@Override
	public void addCustomer(String customerId, String firstName, String lastName, String email, String phone) {
		customerRepository.save(customerDomainService.createCustomer(customerId, firstName, lastName, email, phone));
	}

	@Override
	public Customer getCustomer(String customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public void addCreditCard(String customerId, String cardName, String cardNumber, LocalDate validTill) {
		Customer customer = customerRepository.findById(customerId).orElse(null);
		if (customer != null) {
			customerDomainService.createAndAddCreditCardToCustomer(customer, cardName, cardNumber, validTill);
			customerRepository.save(customer);
		}
	}

	@Override
	public void addBillingAddress(String customerId, String street, String city, String zip, String state,
			String country) {
		Customer customer = customerRepository.findById(customerId).orElse(null);
		if (customer != null) {
			customerDomainService.createAndAddAddressToCustomer(customer, street, city, zip, state, country,
					AddressType.BillingAddress);
			customerRepository.save(customer);
		}
	}

	@Override
	public void addShippingAddress(String customerId, String street, String city, String zip, String state,
			String country) {
		Customer customer = customerRepository.findById(customerId).orElse(null);
		if (customer != null) {
			customerDomainService.createAndAddAddressToCustomer(customer, street, city, zip, state, country,
					AddressType.ShippingAddres);
			customerRepository.save(customer);
		}
	}
	
	@EventListener
	public void onEvent(OrderEventData event) {
		System.out.println("Thank you dear customer for confirming the order, your orderId:" + event.getOrderId());;
	}

}
