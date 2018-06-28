package swa.lab3.problem3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swa.lab3.problem3.domain.Product;
import swa.lab3.problem3.domain.Stock;
import swa.lab3.problem3.repository.ProductRepository;
import swa.lab3.problem3.service.ProductCatalogService;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Autowired
	ProductRepository pr;

	@Override
	public void addProduct(Product p) {
		pr.save(p);
	}

	@Override
	public Product getProduct(String productNumber) {
		return pr.findById(productNumber).orElse(null);
	}

	@Override
	public void setStock(String productNumber, int quantity, String locationCode) {
		
		Stock stock = new Stock();
		stock.setQuantity(quantity);
		stock.setLocationCode(locationCode);
		
		Product product = pr.findById(productNumber).orElse(null);
		if(product != null)
		product.addStock(stock);
		
	}

	@Override
	public List<Product> getAllProduct() {
		return pr.findAll();
	}

}
