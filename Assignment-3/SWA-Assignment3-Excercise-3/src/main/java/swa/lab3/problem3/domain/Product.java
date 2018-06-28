package swa.lab3.problem3.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	String productNumber;
	String description;
	Double price;
	List<Stock> stocks;
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
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
