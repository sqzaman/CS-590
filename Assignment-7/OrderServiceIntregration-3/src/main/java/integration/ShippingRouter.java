package integration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class ShippingRouter {
	
	public String route(Order order) {
		System.out.println("[ShippingRouter] Orders starting with 'I' will ship \"International\": " + order);
		if (order.getOrdernumber().startsWith("I"))
			return "internationalChannel";
		else
			return "domesticChannel";
	}
}
