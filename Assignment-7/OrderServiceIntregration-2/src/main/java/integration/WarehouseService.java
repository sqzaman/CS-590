package integration;

public class WarehouseService {
	public String orderReceived(Order order) {
		System.out.println("New order received:" + order );
		String destinationChannel = null;		
		if(order.getAmount() > 175)
			destinationChannel = "nextDayShippingServiceChannel";		
		else
			destinationChannel = "normalShippingServiceChannel";
		
		
		return destinationChannel;
	}

}
