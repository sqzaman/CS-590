package swa.lab3.problem3.service;

import java.util.List;

import swa.lab3.problem3.domain.Product;

public interface ProductCatalogService {
	public void addProduct(Product p);
	public Product getProduct(String productnumber);
	public void setStock(String productnumber, int quantity, String locationcode);
	public List<Product> getAllProduct();
}
