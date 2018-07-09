package shop.products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.products.domain.Product;
import shop.products.service.ProductCatalogService;
import shop.products.service.ProductDTO;

@RestController
public class ProductController {
	@Autowired
	ProductCatalogService productCatalogService;

	@GetMapping("/get/{productNumber}")
	public ResponseEntity<?> getProduct(@PathVariable String productNumber) {
		ProductDTO productDTO = productCatalogService.getProduct(productNumber);
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/add/{productNumber}/{description}/{price}")
	public ResponseEntity<?> addProduct(@PathVariable String productNumber, @PathVariable String description,
			@PathVariable double price) {
		productCatalogService.addProduct(productNumber, description, price);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	@PostMapping(value = "/setStock/{productNumber}/{quantity}/{locationcode}")
	public ResponseEntity<?> setStock(@PathVariable String productNumber, @PathVariable int quantity, @PathVariable String locationcode){
		productCatalogService.setStock(productNumber, quantity, locationcode);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateStock/{productNumber}/{quantity}")
	public ResponseEntity<?> updateStock(@PathVariable String productNumber, @PathVariable int quantity){
		productCatalogService.updateStock(productNumber, quantity);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
