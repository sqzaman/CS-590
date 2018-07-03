package shop.component.order.dto;

import java.util.List;

import shop.component.order.domain.OrderAddress;

public class OrderCustomerDto {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private List<CreditCardDto> creditCards;
	private OrderAddressDto billingAddress;
	private OrderAddressDto shippingAddress;

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

	public List<CreditCardDto> getCreditCards() {
		return creditCards;
	}
	
	public void setCreditCards(List<CreditCardDto> creditCards) {
		this.creditCards = creditCards;
	}

	public void addCreditCard(CreditCardDto creditCard) {
		this.creditCards.add(creditCard);
	}
	public OrderAddressDto getBillingAddress() {
		return billingAddress;
	}

	public OrderAddressDto getShippingAddress() {
		return shippingAddress;
	}

}
