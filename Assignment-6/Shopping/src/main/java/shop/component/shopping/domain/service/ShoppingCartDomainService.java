package shop.component.shopping.domain.service;

import org.springframework.stereotype.Service;

import shop.component.shopping.domain.CartItem;
import shop.component.shopping.domain.Product;
import shop.component.shopping.domain.ShoppingCart;




@Service
public class ShoppingCartDomainService {

	public ShoppingCart createNewShoppingCart(String cartId) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCartId(cartId);
		return shoppingCart;
	}
	public void addItemToCart(ShoppingCart sc, Product product, int quantity) {
		CartItem cartItem = new CartItem(product, quantity);
		sc.addCartItem(cartItem);
	}
}
