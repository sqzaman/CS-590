package kafka;

public class Order implements java.io.Serializable {
	String orderNumber;
	int quantity;
	double totalPrice;
	
	public Order(String orderNumber, int quantity, double totalPrice) {
		super();
		this.orderNumber = orderNumber;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public Order() {
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
}