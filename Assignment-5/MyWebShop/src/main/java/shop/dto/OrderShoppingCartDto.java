package shop.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shop.component.order.domain.OrderItem;
import shop.component.order.domain.OrderProduct;
import shop.component.shopping.domain.CartItem;
import shop.component.shopping.domain.ShoppingCart;
import shop.component.shopping.service.impl.ShoppingService;


public class OrderShoppingCartDto {

	String cartId;
	List<OrderItem> orderItems;

	@Autowired
	ShoppingService shoppingService;
	public OrderShoppingCartDto(String cartId) {
		ShoppingCart shoppingCart = shoppingService.getCart(cartId);		
		orderItems = new ArrayList<OrderItem>();
		this.cartId = shoppingCart.getCartId();
		for(CartItem cartItem: shoppingCart.getCartItems()) {
			orderItems.add(new OrderItem(
					new OrderProduct(cartItem.getProduct().getProductId(), 
							cartItem.getProduct().getName(), cartItem.getProduct().getPrice()),
					cartItem.getQuantity()
					));
		}
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

}
