package shop.dto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.component.customer.domain.customer.Customer;
import shop.component.customer.service.impl.CustomerService;
import shop.component.product.domain.Product;
import shop.component.product.service.impl.ProductService;
import shop.component.shopping.service.impl.ShoppingService;
import shop.dto.OrderCustomerDto;
import shop.dto.OrderShoppingCartDto;
import shop.dto.ShoppingProductDto;

@Service
public class ShopDtoService {
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	

	@Autowired
	ShoppingService shoppingService;
	
	public ShoppingProductDto getShoppingProductDto(String productId) {
		Product product = productService.getProduct(productId);
		if(product != null)
			return new ShoppingProductDto(product.getProductId(), product.getName(), product.getPrice());
		
		return null;
	}
	
	public OrderCustomerDto getOrderCustomerDto(String customerId) {
		return new OrderCustomerDto(customerService.getCustomer(customerId));
	}
	
	public OrderShoppingCartDto getOrderShoppingCartDto(String cartId) {
		return new OrderShoppingCartDto(shoppingService.getCart(cartId));
	}
}
