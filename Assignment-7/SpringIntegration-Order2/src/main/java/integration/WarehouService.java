package integration;

public class WarehouService {
	public Order print(Order order) throws Exception {
		System.out.println("[Warehouseservice] " + order);
		return order;
	}
}
