package integration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/order")
public class Controller {
	@Autowired
	private OrderGateway gateway;
	
	/*
	@RequestMapping("/greeting/{name}")
	public String getGreeting(@PathVariable("name") String name) {
		Message<String> helloMessage =  MessageBuilder.withPayload(name.toUpperCase()).build();

		String result = gateway.handleRequest(helloMessage);
		return result;
	}
	*/
	@RequestMapping(value ="/publishOrder", method = RequestMethod.POST)
	public String getGreeting( @RequestBody Order order) {
		Message<Order> orderMessage =  MessageBuilder.withPayload(order).build();

		String result = gateway.handleRequest(orderMessage);
		return result;
	}
}
