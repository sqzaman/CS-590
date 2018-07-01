package shop.dto;

import org.springframework.beans.factory.annotation.Autowired;

import shop.component.customer.domain.customer.CreditCard;
import shop.component.customer.domain.customer.Customer;
import shop.component.customer.domain.customer.CustomerAddress;
import shop.component.customer.service.impl.CustomerService;
import shop.component.order.domain.OrderAddress;

public class OrderCustomerDto {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private CreditCard creditCard;
	private OrderAddress orderBillingAddress;
	private OrderAddress orderShippingAddress;

	@Autowired
	CustomerService customerService;

	public OrderCustomerDto(String customerId) {
		Customer customer = customerService.getCustomer(customerId);
		this.customerId = customer.getCustomerId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.email = customer.getEmail();
		this.phone = customer.getPhone();
		// i am taking first credit card for available list, may be some logic will
		// added in real scenario
		this.creditCard = customer.getCreditCards().get(0);

		CustomerAddress customerBillingAddress = customer.getBillingAddress();
		this.orderBillingAddress = new OrderAddress(customerBillingAddress.getStreet(),
				customerBillingAddress.getCity(), customerBillingAddress.getZip(), customerBillingAddress.getState(),
				customerBillingAddress.getCountry());
		
		CustomerAddress customerShippingAddress = customer.getShippingAddress();
		this.orderShippingAddress = new OrderAddress(customerShippingAddress.getStreet(),
				customerShippingAddress.getCity(), customerShippingAddress.getZip(), customerShippingAddress.getState(),
				customerShippingAddress.getCountry());
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

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public OrderAddress getOrderBillingAddress() {
		return orderBillingAddress;
	}

	public OrderAddress getOrderShippingAddress() {
		return orderShippingAddress;
	}

}
