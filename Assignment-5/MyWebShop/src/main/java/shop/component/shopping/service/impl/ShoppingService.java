package shop.component.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.component.order.service.impl.OrderService;
import shop.component.shopping.domain.Product;
import shop.component.shopping.domain.ShoppingCart;
import shop.component.shopping.domain.service.ShoppingCartDomainService;
import shop.component.shopping.repository.ShoppingCartRepository;
import shop.component.shopping.service.IShopping;
import shop.dto.ShoppingProductDto;
import shop.util.Helper;


@Service
public class ShoppingService implements IShopping {
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	@Autowired
	ShoppingCartDomainService shoppingCartDomainService;	
	
	@Autowired
	OrderService orderService;
	
	
	@Override
	public String addToCart(String productId, String cartId, int quantity) {
		ShoppingCart shoppingCart = null;
		ShoppingProductDto shoppingProductDto = new ShoppingProductDto(productId);
		if(cartId == null || cartId == "") {
			shoppingCart =  shoppingCartDomainService.createNewShoppingCart(Helper.getInstance().generateRandomString());
		} else {
			shoppingCart = shoppingCartRepo.findById(cartId).orElse(null);
		}
			
		if(shoppingProductDto != null && shoppingCart != null ) {
			shoppingCartDomainService.addItemToCart(shoppingCart, 
					new Product(shoppingProductDto.getProductId(),
							shoppingProductDto.getName(), shoppingProductDto.getPrice()), quantity);
			shoppingCartRepo.save(shoppingCart);
			return cartId;
		}
		
		return null;
	}

	@Override
	public ShoppingCart getCart(String cartId) {
		return shoppingCartRepo.findById(cartId).orElse(null);
	}
	
	@Override
	public String checkOut(String customerId, String cartId) {
		//ShoppingCart shoppingCart = this.getCart(cartId);
		//if(shoppingCart != null) {
			return orderService.createOrder(customerId, cartId);
		//}
		//return null;
	}
	
	/*
	@Autowired
	ProductService productService;
	
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ShoppingCartDomainService shoppingCartDomainService;	

	@Override
	public String addToCart(String productId, int quantity, String cartId) {
		ShoppingCart sc = null;
		ProductDto productDto = productService.getProductDto(productId);
		if(cartId == null || cartId == "") {
			cartId = Helper.getInstance().generateRandomString();
			sc =  new ShoppingCart();
			sc.setCartId(cartId);
		} else {
			sc = shoppingCartRepo.findById(cartId).orElse(null);
		}
			
		if(productDto != null && sc != null ) {
			shoppingCartDomainService.addItemToCart(sc, 
					new Product(productDto.getProductId(),
							productDto.getName(), productDto.getDescription(), productDto.getPrice()), quantity);
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

*/
}
