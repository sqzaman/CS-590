package swa.lab3.problem3.controller;

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
import swa.lab3.problem3.domain.ShoppingCart;
import swa.lab3.problem3.message.NotFoundMessage;
import swa.lab3.problem3.message.SuccessMessage;
import swa.lab3.problem3.service.ProductCatalogService;
import swa.lab3.problem3.service.ShoppingService;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping("/addItem")
	public ResponseEntity<?> addBook(
			@PathVariable("productNumber") String productNumber,
			@PathVariable("quantity") int quantity,
			@PathVariable("cartId") String cartId
			){
		String cartIdentifier = shoppingService.addToCart(productNumber, quantity, cartId);
		if(cartIdentifier != null && cartIdentifier != "") {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added! cartId is in identifier", cartIdentifier), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Something went wrong!"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/get/{cartId}")
	public ResponseEntity<?> getGreeting(@PathVariable("cartId") String cartId){		
		
		ShoppingCart sc = shoppingService.getCart(cartId);
		if (sc != null)
		return new ResponseEntity<ShoppingCart>(sc,  HttpStatus.OK );
		else 
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no shopping cart found"), HttpStatus.NOT_FOUND);
	}
	
	
}
