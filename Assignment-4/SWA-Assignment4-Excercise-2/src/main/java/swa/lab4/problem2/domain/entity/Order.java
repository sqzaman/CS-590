package swa.lab4.problem2.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import swa.lab4.problem2.domain.entity.valueobject.OrderItem;

@Document
public class Order {
	@Id
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
