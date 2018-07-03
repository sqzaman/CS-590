package shop.component.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderItem {
	OrderProduct orderProduct;
	int quantity;


	
	public OrderItem(OrderProduct orderProduct, int quantity) {
		this.quantity = quantity;
		this.orderProduct = orderProduct;
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
