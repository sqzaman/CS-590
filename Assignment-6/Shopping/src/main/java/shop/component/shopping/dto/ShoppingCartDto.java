package shop.component.shopping.dto;

import java.util.List;

import shop.component.shopping.domain.CartItem;

public class ShoppingCartDto {
	String cartId;
	List<CartItem> cartItems;
	String customerId;
	public ShoppingCartDto() {
		
	}
	public ShoppingCartDto(String cartId, List<CartItem> cartItems){
		this.cartId = cartId;
		this.cartItems = cartItems;
	}
	public ShoppingCartDto(String customerId, String cartId, List<CartItem> cartItems){
		this.customerId = customerId;
		this.cartId = cartId;
		this.cartItems = cartItems;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
