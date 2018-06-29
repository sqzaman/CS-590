package swa.lab4.problem2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.Product;
import swa.lab4.problem2.domain.entity.ShoppingCart;
import swa.lab4.problem2.domain.service.ShoppingCartDomainService;
import swa.lab4.problem2.repository.ProductRepository;
import swa.lab4.problem2.repository.ShoppingCartRepository;
import swa.lab4.problem2.service.OrderService;
import swa.lab4.problem2.service.ShoppingService;
import swa.lab4.problem2.util.Helper;


@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ShoppingCartDomainService shoppingCartDomainService;	
	@Autowired
	OrderService orderService;

	@Override
	public String addToCart(String productId, int quantity, String cartId) {
		// TODO Auto-generated method stub
		ShoppingCart sc = null;
		Product p = productRepo.findById(productId).orElse(null);
		if(cartId == null || cartId == "") {
			cartId = Helper.getInstance().generateRandomString();
			sc =  new ShoppingCart();
			sc.setCartId(cartId);
		} else {
			sc = shoppingCartRepo.findById(cartId).orElse(null);
		}
			
		if(p != null && sc != null ) {

			shoppingCartDomainService.addItemToCart(sc, productId, quantity);
			shoppingCartRepo.save(sc);
			return cartId;
		}
		
		return null;
		
	}

	@Override
	public ShoppingCart getCart(String cartId) {
		return shoppingCartRepo.findById(cartId).orElse(null);
	}

	@Override
	public Order checkOut(String cartId) {
		ShoppingCart shoppingCart = shoppingCartRepo.findById(cartId).orElse(null);
		if(shoppingCart != null) {
			return orderService.createOrder(shoppingCart);
		}
		return null;
	}


}
