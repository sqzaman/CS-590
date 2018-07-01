package shop.component.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shop.component.shopping.domain.ShoppingCart;
import shop.component.shopping.service.impl.ShoppingService;
import shop.message.NotFoundMessage;
import shop.message.SuccessMessage;


@RestController
@RequestMapping("/shoppingCart")
public class ShoppingController {

	@Autowired
	ShoppingService shoppingService;

	@PostMapping("/addItem")
	public ResponseEntity<?> addItem(
			@RequestParam(value = "productId") final String productId,
			@RequestParam(value = "quantity") final int quantity,
			@RequestParam(value = "cartId", required = false) final String cartId) {
		String cartIdentifier = shoppingService.addToCart(productId, cartId, quantity);
		if (cartIdentifier != null && cartIdentifier != "") {
			return new ResponseEntity<SuccessMessage>(
					new SuccessMessage("Successfully added! cartId is in identifier", cartIdentifier), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Something went wrong!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable("cartId") String cartId) {

		ShoppingCart sc = shoppingService.getCart(cartId);
		if (sc != null)
			return new ResponseEntity<ShoppingCart>(sc, HttpStatus.OK);
		else
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no shopping cart found"),
					HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/checkOut")
	public ResponseEntity<?> checkOut(
			@RequestParam(value = "customerId") final String customerId,
			@RequestParam(value = "cartId") final String cartId) {

		String orderId = shoppingService.checkOut(customerId, cartId);
		if (orderId != null || orderId != "")
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully order created! orderId is in identifier", orderId), HttpStatus.OK);
		else
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no customer/shopping cart found"),
					HttpStatus.NOT_FOUND);
	}	
}
