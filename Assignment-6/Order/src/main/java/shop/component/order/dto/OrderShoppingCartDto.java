package shop.component.order.dto;

import java.util.ArrayList;
import java.util.List;



public class OrderShoppingCartDto {
	String cartId;
	List<CartItemDto> cartItems;
	String customerId;
	public OrderShoppingCartDto() {
		//cartItems = new ArrayList<CartItemDto>();
	}
	public OrderShoppingCartDto(String cartId, List<CartItemDto> cartItems){
		this.cartId = cartId;
		this.cartItems = cartItems;
	}
	public OrderShoppingCartDto(String customerId, String cartId, List<CartItemDto> cartItems){
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
	public List<CartItemDto> getCartItems() {
		return cartItems;
	}
	public void addCartItem(CartItemDto cartItem) {
		this.cartItems.add(cartItem);
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
