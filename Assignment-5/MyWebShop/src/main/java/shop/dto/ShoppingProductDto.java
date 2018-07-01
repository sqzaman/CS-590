package shop.dto;

import org.springframework.beans.factory.annotation.Autowired;

import shop.component.product.domain.Product;
import shop.component.product.service.impl.ProductService;

public class ShoppingProductDto {
	
	private String productId;
	private String name;
	private double price;

	@Autowired
	ProductService productService;
	
	public ShoppingProductDto(String productId) {
		this.productId = productId;		
		Product product = productService.getProduct(productId);
		if(product != null) {
			this.setName(product.getName());
			this.setPrice(product.getPrice());
		}
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Product Id:%s, Name:%s, Price:%", productId, name, price);
	}
}
