package swa.lab3.problem3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import swa.lab3.problem3.domain.CartLine;
import swa.lab3.problem3.domain.Product;
import swa.lab3.problem3.domain.ShoppingCart;
import swa.lab3.problem3.repository.ProductRepository;
import swa.lab3.problem3.repository.ShoppingCartRepository;
import swa.lab3.problem3.service.ShoppingService;
import swa.lab3.problem3.util.Helper;

public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	@Autowired
	ProductRepository productRepo;

	@Override
	public String addToCart(String productNumber, int quantity, String cartId) {
		// TODO Auto-generated method stub
		ShoppingCart sc = null;
		Product p = productRepo.findById(productNumber).orElse(null);
		if(cartId == null || cartId == "") {
			cartId = Helper.getInstance().generateRandomString();
			sc =  new ShoppingCart();			
		} else {
			sc = shoppingCartRepo.findById(cartId).orElse(null);
		}
			
		if(p != null && sc != null ) {
			CartLine cartLine = new CartLine();
			cartLine.setProduct(p);
			cartLine.setQuantity(quantity);
			sc.addCartLine(cartLine);
			shoppingCartRepo.save(sc);
			return cartId;
		}
		
		return null;
		
	}

	@Override
	public ShoppingCart getCart(String cartId) {
		return shoppingCartRepo.findById(cartId).orElse(null);
	}


}
