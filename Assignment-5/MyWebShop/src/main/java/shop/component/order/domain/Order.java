package shop.component.order.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Order {
	@Id
	String orderId;
	OrderCustomer customer;
	OrderAddress billingAddress;
	OrderAddress shippingAddress;
	OrderCreditCard creditCard;
	List<OrderItem> orderItems;
	
	public Order() {
		this.orderItems = new ArrayList<OrderItem>();
	}
	public String getOrderId() {
		return orderId;
	}
	public OrderCustomer getCustomer() {
		return customer;
	}
	public OrderAddress getBillingAddress() {
		return billingAddress;
	}
	public OrderAddress getShippingAddress() {
		return shippingAddress;
	}
	public OrderCreditCard getCreditCard() {
		return creditCard;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setCustomer(OrderCustomer customer) {
		this.customer = customer;
	}
	public void setBillingAddress(OrderAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public void setShippingAddress(OrderAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public void setCreditCard(OrderCreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public void addOrderItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}
	

	
}
