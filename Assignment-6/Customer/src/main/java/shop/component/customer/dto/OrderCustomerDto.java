package shop.component.customer.dto;

import shop.component.customer.domain.CreditCard;
import shop.component.customer.domain.Customer;
import shop.component.customer.domain.CustomerAddress;


public class OrderCustomerDto {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private CreditCard creditCard;
	private OrderAddressDto orderBillingAddress;
	private OrderAddressDto orderShippingAddress;

	

	public OrderCustomerDto(Customer customer) {
		
		this.customerId = customer.getCustomerId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.email = customer.getEmail();
		this.phone = customer.getPhone();
		// i am taking first credit card for available list, may be some logic will
		// added in real scenario
		this.creditCard = customer.getCreditCards().get(0);

		CustomerAddress customerBillingAddress = customer.getBillingAddress();
		this.orderBillingAddress = new OrderAddressDto(customerBillingAddress.getStreet(),
				customerBillingAddress.getCity(), customerBillingAddress.getZip(), customerBillingAddress.getState(),
				customerBillingAddress.getCountry());
		
		CustomerAddress customerShippingAddress = customer.getShippingAddress();
		this.orderShippingAddress = new OrderAddressDto(customerShippingAddress.getStreet(),
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

	public OrderAddressDto getOrderBillingAddress() {
		return orderBillingAddress;
	}

	public OrderAddressDto getOrderShippingAddress() {
		return orderShippingAddress;
	}

}
