package shop.component.shopping.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart {
	@Id
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
