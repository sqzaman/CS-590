package swa.lab4.problem2.domain.service;

import org.springframework.stereotype.Service;

import swa.lab4.problem2.domain.entity.ShoppingCart;
import swa.lab4.problem2.domain.entity.valueobject.CartItem;


@Service
public class ShoppingCartDomainService {

	public void addItemToCart(ShoppingCart sc, String productId, int quantity) {
		CartItem cartItem = new CartItem(productId, quantity);
		sc.addCartItem(cartItem);
	}
}
