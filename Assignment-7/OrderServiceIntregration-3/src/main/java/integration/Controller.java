package integration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@Autowired
	private OrderGateway gateway;
	
	@RequestMapping("/order/{ordernum}/{amount}")
	public ResponseEntity<?> order(@PathVariable("ordernum") String ordernum,
							  @PathVariable("amount") double amount) {
		System.out.println("[Controller] ordernum: " + ordernum + "; amount: " + amount);
		Message<Order> order =  MessageBuilder.withPayload(new Order(ordernum, amount)).build();
		Order result = gateway.handleRequest(order);
		return new ResponseEntity<Order>(result, HttpStatus.OK);
	}
}
