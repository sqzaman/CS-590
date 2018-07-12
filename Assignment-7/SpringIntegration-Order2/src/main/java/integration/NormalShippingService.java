package integration;

public class NormalShippingService {
	public Order print(Order order) throws Exception {
		System.out.println("[NormalShippingService] " + order);
		return order;
	}

}
