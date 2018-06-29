package swa.lab4.problem2.domain.service;

import org.springframework.stereotype.Service;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.ShoppingCart;
import swa.lab4.problem2.domain.entity.valueobject.CartItem;
import swa.lab4.problem2.domain.entity.valueobject.OrderItem;
import swa.lab4.problem2.util.Helper;

@Service
public class OrderDomainService {
	public Order createOrderFormCart(ShoppingCart sc) {
		Order order = new Order();
		order.setOrderId(Helper.getInstance().generateRandomString());
		for (CartItem ci : sc.getCartItems()) {
			order.addOrderItem(new OrderItem(ci.getProductId(), ci.getQuantity()));
		}
		return order;
	}

	public Order createOrderFormCart(String orderId, ShoppingCart sc) {
		Order order = new Order();
		order.setOrderId(orderId);
		for (CartItem ci : sc.getCartItems()) {
			order.addOrderItem(new OrderItem(ci.getProductId(), ci.getQuantity()));
		}
		return order;
	}
}
