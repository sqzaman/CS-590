package integration;

public class WarehouseService {
	public Order printOrder(Order order) throws Exception {
		System.out.println("Warehuse service got a new order..." + order);
		return order;
	}

}
