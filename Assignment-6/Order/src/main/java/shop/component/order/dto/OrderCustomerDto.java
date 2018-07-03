package shop.component.order.dto;

import shop.component.order.domain.OrderAddress;

public class OrderCustomerDto {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private CreditCardDto creditCard;
	private OrderAddressDto orderBillingAddress;
	private OrderAddressDto orderShippingAddress;

	public OrderCustomerDto() {	
	
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

	public CreditCardDto getCreditCard() {
		return creditCard;
	}

	public OrderAddressDto getOrderBillingAddress() {
		return orderBillingAddress;
	}

	public OrderAddressDto getOrderShippingAddress() {
		return orderShippingAddress;
	}

}
