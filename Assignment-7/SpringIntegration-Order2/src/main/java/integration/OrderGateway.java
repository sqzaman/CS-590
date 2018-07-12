package integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;


@MessagingGateway
public interface OrderGateway {

	@Gateway(requestChannel = "orderReceiveChannel")
	Order handleRequest(Message<Order> order);
}
