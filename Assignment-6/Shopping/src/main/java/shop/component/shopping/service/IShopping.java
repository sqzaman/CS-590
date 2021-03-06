package shop.component.shopping.service;

import shop.component.shopping.domain.ShoppingCart;

public interface IShopping {
	String addToCart(String cartId, String productId, int quantity);
	ShoppingCart getCart(String cartId);
	String checkOut(String customerId, String cartId);
}
