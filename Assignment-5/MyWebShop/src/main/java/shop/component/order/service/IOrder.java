package shop.component.order.service;

import shop.component.order.domain.Order;

public interface IOrder {
	String createOrder(String customerId, String cartId);
	Order getOrder(String orderId);
}
