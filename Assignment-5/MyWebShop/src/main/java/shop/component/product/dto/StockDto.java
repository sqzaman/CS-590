package shop.component.product.dto;

public class StockDto {
	
	String locationCode;
	int quantity;
	String productId;
	public StockDto() {}
	public StockDto(String productId, String locationCode, int quantity) {
		this.productId = productId;
		this.locationCode = locationCode;
		this.quantity = quantity;
	}
	
	public String getLocationCode() {
		return locationCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setLocationcode(String locationCode) {
		this.locationCode = locationCode;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("Lcation code:%s, Quantity:%s", locationCode, quantity);
	}

}
