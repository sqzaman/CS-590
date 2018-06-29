package swa.lab4.problem2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swa.lab4.problem2.domain.entity.Product;
import swa.lab4.problem2.domain.entity.valueobject.Stock;
import swa.lab4.problem2.domain.service.ProductDomainService;
import swa.lab4.problem2.repository.ProductRepository;
import swa.lab4.problem2.service.ProductCatalogService;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Autowired
	ProductRepository pr;

	@Autowired
	ProductDomainService productDomainService;

	@Override
	public void addProduct(Product p) {
		pr.save(p);
	}

	@Override
	public Product getProduct(String productNumber) {
		return pr.findById(productNumber).orElse(null);
	}

	@Override
	public void setStock(String productId, int quantity, String locationCode) {

		Product product = getProduct(productId);
		if (product != null) {
			product.addStock(productDomainService.getStockObject(quantity, locationCode));
			//product.addStock(new Stock(locationCode, quantity));
			pr.save(product);
		}
		
	}

	@Override
	public List<Product> getAllProduct() {
		return pr.findAll();
	}

}
