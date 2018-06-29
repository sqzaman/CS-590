package rest.client.entity;

import java.util.ArrayList;
import java.util.List;



import rest.client.entity.valueobject.CartItem;


public class ShoppingCart {

	String cartId;

	List<CartItem> cartItems;

	public ShoppingCart() {
		cartItems = new ArrayList<CartItem>();
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void addCartItem(CartItem cartItem) {
		this.cartItems.add(cartItem);
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

}
