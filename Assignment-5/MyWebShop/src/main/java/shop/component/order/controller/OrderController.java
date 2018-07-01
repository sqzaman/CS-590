package shop.component.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.component.order.domain.Order;
import shop.component.order.service.impl.OrderService;
import shop.message.NotFoundMessage;



@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	
	@GetMapping("/get/{orderId}")
	public ResponseEntity<?> getCart(@PathVariable("orderId") String orderId) {

		Order order = orderService.getOrder(orderId);
		if (order != null)
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		else
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no order found"),
					HttpStatus.NOT_FOUND);
	}	
	
}
