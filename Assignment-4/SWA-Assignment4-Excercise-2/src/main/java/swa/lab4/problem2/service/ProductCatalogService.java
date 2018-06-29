package swa.lab4.problem2.service;

import java.util.List;

import swa.lab4.problem2.domain.entity.Product;



public interface ProductCatalogService {
	public void addProduct(Product p);
	public Product getProduct(String productId);
	public void setStock(String productId, int quantity, String locationcode);
	public List<Product> getAllProduct();
}
