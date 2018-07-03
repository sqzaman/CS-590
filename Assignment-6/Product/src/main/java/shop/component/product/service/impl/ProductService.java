package shop.component.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import shop.component.product.domain.Product;
import shop.component.product.domain.service.ProductDomainService;
import shop.component.product.repository.ProductRepository;
import shop.component.product.service.IProduct;
import shop.event.OrderEventData;

@Service
public class ProductService implements IProduct {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductDomainService productDomainService;

	@Override
	public void addProduct(String productId, String name, String description, double price) {
		productRepository.save(
				productDomainService.createProduct(productId, name, description, price)
				);
	}

	@Override
	public Product getProduct(String productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public void setStock(String productId, String locationCode, int quantity) {
		Product product = this.getProduct(productId);
		if(product != null) {
			productDomainService.setStock(product, locationCode, quantity);
			productRepository.save(product);
		}
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	/*
	public ProductDto getProductDto(String productId) {
		Product product  = this.getProduct(productId);
		return new ProductDto(product.getProductId(), product.getName(), product.getDescription(), product.getPrice());
	}
	
	public List<ProductDto> getAllProductDto() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productsDto = new ArrayList<>();
		
		products.forEach( (p) -> {
			productsDto.add(new ProductDto(p.getProductId(),p.getName(), p.getDescription(), p.getPrice()));
		});
		
		return productsDto;
	}
	*/
	@EventListener
	public void onEvent(OrderEventData event) {
		System.out.println("New order placed product inventory need to updated, orderId: :" + event.getOrderId());;
	}

}
