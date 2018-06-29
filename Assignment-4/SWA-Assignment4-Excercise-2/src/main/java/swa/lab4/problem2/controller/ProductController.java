package swa.lab4.problem2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swa.lab4.problem2.domain.entity.Product;
import swa.lab4.problem2.domain.entity.valueobject.Stock;
import swa.lab4.problem2.dto.StockDto;
import swa.lab4.problem2.message.NotFoundMessage;
import swa.lab4.problem2.message.SuccessMessage;
import swa.lab4.problem2.service.ProductCatalogService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductCatalogService productCatalogService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBook(@RequestBody Product p){
		productCatalogService.addProduct(p);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<?> getGreeting(@PathVariable("productId") String productId){
		Product p = productCatalogService.getProduct(productId);
		if (p != null)
		return new ResponseEntity<Product>(p,  HttpStatus.OK );
		else 
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no product found"), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productCatalogService.getAllProduct(), HttpStatus.OK);
	}
	
	@PostMapping("/setStock")
	public ResponseEntity<?> setStock(
			@RequestBody StockDto s
			){
		productCatalogService.setStock(s.getProductId(), s.getQuantity(), s.getLocationCode());
		//return new ResponseEntity<SuccessMessage>(new SuccessMessage("successfully updated stock"), HttpStatus.OK);
		Product p = productCatalogService.getProduct(s.getProductId());
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
}
