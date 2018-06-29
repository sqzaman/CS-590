package swa.lab4.problem2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.ShoppingCart;
import swa.lab4.problem2.message.NotFoundMessage;
import swa.lab4.problem2.message.SuccessMessage;
import swa.lab4.problem2.service.ShoppingService;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	ShoppingService shoppingService;

	@PostMapping("/addItem")
	public ResponseEntity<?> addItem(
			@RequestParam(value = "productId") final String productId,
			@RequestParam(value = "quantity") final int quantity,
			@RequestParam(value = "cartId", required = false) final String cartId) {
		String cartIdentifier = shoppingService.addToCart(productId, quantity, cartId);
		if (cartIdentifier != null && cartIdentifier != "") {
			return new ResponseEntity<SuccessMessage>(
					new SuccessMessage("Successfully added! cartId is in identifier", cartIdentifier), HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Something went wrong!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{cartId}")
	public ResponseEntity<?> getGreeting(@PathVariable("cartId") String cartId) {

		ShoppingCart sc = shoppingService.getCart(cartId);
		if (sc != null)
			return new ResponseEntity<ShoppingCart>(sc, HttpStatus.OK);
		else
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no shopping cart found"),
					HttpStatus.NOT_FOUND);
	}

	@PostMapping("/checkOut")
	public ResponseEntity<?> checkOut(@RequestParam(value = "cartId") final String cartId) {

		Order order = shoppingService.checkOut(cartId);
		if (order != null)
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		else
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no shopping cart found"),
					HttpStatus.NOT_FOUND);
	}
}
