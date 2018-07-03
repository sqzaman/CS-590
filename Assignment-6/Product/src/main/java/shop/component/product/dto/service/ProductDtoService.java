package shop.component.product.dto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.component.product.domain.Product;
import shop.component.product.dto.OrderProductDto;
import shop.component.product.dto.ShoppingProductDto;
import shop.component.product.service.impl.ProductService;


@Service
public class ProductDtoService {
	@Autowired
	ProductService productService;

	
	public ShoppingProductDto getShoppingProductDto(String productId) {
		Product product = productService.getProduct(productId);
		if(product != null)
			return new ShoppingProductDto(product.getProductId(), product.getName(), product.getPrice());
		
		return null;
	}
	
	public OrderProductDto getOrderProductDto(String productId) {
		Product product = productService.getProduct(productId);
		if(product != null)
			return new OrderProductDto(product.getProductId(), product.getName(), product.getDescription(),  product.getPrice());
		
		return null;
	}

}
