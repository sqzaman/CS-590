package integration;

public class NextDayShippingService {
	public void printOrder(Order order) throws Exception {
		System.out.println("Shipping service got a new order...." + order);
	}

}
