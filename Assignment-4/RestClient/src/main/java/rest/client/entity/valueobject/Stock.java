package rest.client.entity.valueobject;


final public class Stock {

	private String locationCode;
	private int quantity;
	

	public Stock(String locationCode, int quantity) {

		this.locationCode = locationCode;
		this.quantity = quantity;
	}	
	
	public String getLocationCode() {
		return locationCode;
	}

	public int getQuantity() {
		return quantity;
	}


}
