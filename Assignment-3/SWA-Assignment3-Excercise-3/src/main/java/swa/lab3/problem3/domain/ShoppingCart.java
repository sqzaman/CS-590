package swa.lab3.problem3.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart {
	@Id
	String cartId;
	
	List<CartLine> cartLines;

	public List<CartLine> getCartLines() {
		return cartLines;
	}

	public void addCartLine(CartLine cartLine) {
		this.cartLines.add(cartLine);
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	
	
}
