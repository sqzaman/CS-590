package swa.lab4.problem2.service;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.ShoppingCart;

public interface ShoppingService {
	String addToCart(String productNumber, int quantity, String cartId);
	ShoppingCart getCart(String cartId);
	Order checkOut(String cartId);
}
