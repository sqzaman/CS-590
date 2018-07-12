package integration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class OrderRouter {
	
	public String route(Order order) {
		if (order.getAmount() > 175) 
			return "nextdayShippingChannel";
		else
			return "normalShippingChannel";
	}
}
