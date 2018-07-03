package shop.component.order.dto;

public class OrderDto {
	String orderId;

	public OrderDto(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
