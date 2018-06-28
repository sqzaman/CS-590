package swa.lab3.problem3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swa.lab3.problem3.domain.Product;
import swa.lab3.problem3.message.NotFoundMessage;
import swa.lab3.problem3.message.SuccessMessage;
import swa.lab3.problem3.service.ProductCatalogService;

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
	
	@GetMapping("/get/{productNumber}")
	public ResponseEntity<?> getGreeting(@PathVariable("productNumber") String productNumber){
		Product p = productCatalogService.getProduct(productNumber);
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
			@PathVariable("productNumber") String productNumber,
			@PathVariable("quantity") int quantity,
			@PathVariable("locationCode") String locationCode
			){
		productCatalogService.setStock(productNumber, quantity, locationCode);;
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("successfully updated stock"), HttpStatus.OK);
	}
}
