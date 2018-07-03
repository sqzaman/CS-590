package shop.component.shopping.dto.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import shop.component.shopping.domain.ShoppingCart;
import shop.component.shopping.dto.ShoppingCartDto;
import shop.component.shopping.dto.ShoppingProductDto;
import shop.component.shopping.repository.ShoppingCartRepository;

@Service
public class ShoppingDtoAdapter {

	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	public ShoppingProductDto getShoppingProductDto(String productId) {
		RestTemplate restTemplate = new RestTemplate();
		ShoppingProductDto shoppingProductDto = restTemplate
				.getForObject("http://localhost:8082/product/get/" + productId, ShoppingProductDto.class);
		return shoppingProductDto;
	}
	
	public ShoppingCartDto getShoppingCartDto(String cartId) {
		ShoppingCartDto shoppingCartDto = null;
		ShoppingCart shoppingCart = shoppingCartRepo.findById(cartId).orElse(null);
		if(shoppingCart != null) {
			shoppingCartDto = new ShoppingCartDto(shoppingCart.getCartId(), shoppingCart.getCartItems());
		}
		return shoppingCartDto;
	}
}
