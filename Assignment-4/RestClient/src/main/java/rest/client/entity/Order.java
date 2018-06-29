package rest.client.entity;

import java.util.ArrayList;
import java.util.List;



import rest.client.entity.valueobject.OrderItem;


public class Order {

	String orderId;
	List<OrderItem> orderItems;
	
	public Order() {
		orderItems = new ArrayList<OrderItem>();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}
	
}
