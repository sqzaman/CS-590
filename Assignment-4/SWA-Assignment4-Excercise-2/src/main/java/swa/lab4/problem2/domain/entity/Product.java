package swa.lab4.problem2.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import swa.lab4.problem2.domain.entity.valueobject.Stock;

@Document
public class Product {
	@Id
	String productId;
	String name;
	String description;
	Double price;
	List<Stock> stocks;
	public Product() {
		stocks = new ArrayList<>();
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void addStock(Stock stock) {
		this.stocks.add(stock);
	}
	
}
