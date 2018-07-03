package shop.component.product.controller;

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

import shop.component.product.domain.Product;
import shop.component.product.dto.StockDto;
import shop.component.product.service.impl.ProductService;
import shop.message.NotFoundMessage;
import shop.message.SuccessMessage;


@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		productService.addProduct(product.getProductId(), product.getName(), product.getDescription(), product.getPrice());
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<?> getProduct(@PathVariable("productId") String productId){
		Product product = productService.getProduct(productId);
		if (product != null)
		return new ResponseEntity<Product>(product,  HttpStatus.OK );
		else 
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no product found"), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}
	
	@PostMapping("/setStock")
	public ResponseEntity<?> setStock(@RequestBody StockDto stockDto){
		productService.setStock(stockDto.getProductId(), stockDto.getLocationCode(), stockDto.getQuantity());
		return new ResponseEntity<Product>(productService.getProduct(stockDto.getProductId()), HttpStatus.OK);
	}
}
