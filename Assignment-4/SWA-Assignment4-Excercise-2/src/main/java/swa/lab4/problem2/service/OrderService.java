package swa.lab4.problem2.service;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.ShoppingCart;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart);
	void createOrder(String orderId, ShoppingCart shoppingCart);
	Order getOrder(String orderId);

}
