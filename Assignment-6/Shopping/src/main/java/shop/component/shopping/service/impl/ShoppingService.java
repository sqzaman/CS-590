package shop.component.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import shop.component.shopping.domain.Product;
import shop.component.shopping.domain.ShoppingCart;
import shop.component.shopping.domain.service.ShoppingCartDomainService;
import shop.component.shopping.dto.OrderDto;
import shop.component.shopping.dto.ShoppingCartDto;
import shop.component.shopping.dto.ShoppingProductDto;
import shop.component.shopping.dto.adapter.ShoppingDtoAdapter;
import shop.component.shopping.repository.ShoppingCartRepository;
import shop.component.shopping.service.IShopping;
import shop.util.Helper;


@Service
public class ShoppingService implements IShopping {
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	@Autowired
	ShoppingCartDomainService shoppingCartDomainService;	
	
	@Autowired
	ShoppingDtoAdapter shoppingDtoAdapter;

	
	@Override
	public String addToCart(String productId, String cartId, int quantity) {
		ShoppingCart shoppingCart = null;
		ShoppingProductDto shoppingProductDto = shoppingDtoAdapter.getShoppingProductDto(productId);
		if(cartId == null || cartId == "") {
			shoppingCart =  shoppingCartDomainService.createNewShoppingCart(Helper.getInstance().generateRandomString());
		} else {
			shoppingCart = shoppingCartRepo.findById(cartId).orElse(null);
		}
			
		if(shoppingProductDto != null && shoppingCart != null ) {
			shoppingCartDomainService.addItemToCart(shoppingCart, 
					new Product(shoppingProductDto.getProductId(),
							shoppingProductDto.getName(), shoppingProductDto.getPrice()), quantity);
			return shoppingCartRepo.save(shoppingCart).getCartId();
			//return cartId;
		}
		
		return null;
	}

	@Override
	public ShoppingCart getCart(String cartId) {
		return shoppingCartRepo.findById(cartId).orElse(null);
	}
	
	@Override
	public String checkOut(String customerId, String cartId) {		
		ShoppingCartDto shoppingCartDto = shoppingDtoAdapter.getShoppingCartDto(cartId);
		shoppingCartDto.setCustomerId(customerId);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<ShoppingCartDto> requestBody = new HttpEntity<>(shoppingCartDto);
		OrderDto orderDto  = restTemplate.postForObject("http://localhost:8085/order/create", requestBody, OrderDto.class);
		if(orderDto != null)
			return orderDto.getOrderId();
		
		return null;
	}

}
