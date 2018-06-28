package swa.lab3.problem3.service;

import swa.lab3.problem3.domain.ShoppingCart;

public interface ShoppingService {
	String addToCart(String productNumber, int quantity, String cartId);
	ShoppingCart getCart(String cartId);
}
