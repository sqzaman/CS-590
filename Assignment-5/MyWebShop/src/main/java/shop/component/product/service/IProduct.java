package shop.component.product.service;

import java.util.List;

import shop.component.product.domain.Product;

public interface IProduct {
	public void addProduct(String productId, String name, String description, double price);
	public Product getProduct(String productId);
	public List<Product> getAllProduct();
	public void setStock(String productId, String locationCode, int quantity);
}
