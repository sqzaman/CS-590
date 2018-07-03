package shop.component.order.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.component.order.domain.Order;
import shop.component.order.domain.OrderAddress;
import shop.component.order.domain.OrderCreditCard;
import shop.component.order.domain.OrderCustomer;
import shop.component.order.domain.OrderItem;
import shop.component.order.dto.OrderCustomerDto;
import shop.component.order.dto.OrderShoppingCartDto;
import shop.event.OrderEventData;
import shop.util.Helper;

@Service
public class OrderDomainService {
	public Order createOrder(OrderCustomer orderCustomer, List<OrderItem> orderItems,
			OrderCreditCard orderCreditCard, OrderAddress billingAddress, OrderAddress shippingAddress) {

		Order order = new Order();

		order.setOrderId(Helper.getInstance().generateRandomString());
		order.setCustomer(orderCustomer);

		order.setCreditCard(orderCreditCard);

		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);

		order.setOrderItems(orderItems);

		return order;
	}

	/*
	public OrderEventData prepareEventData(String orderId, OrderCustomerDto orderCustomerDto,
			OrderShoppingCartDto orderShoppingCartDto) {

		OrderEventData orderEventData = new OrderEventData(orderCustomerDto.getCustomerId(), orderId);
		for (OrderItem orderItem : orderShoppingCartDto.getOrderItems()) {
			orderEventData.addProductToList(orderItem.getOrderProduct().getProductId(), orderItem.getQuantity());
		}

		return orderEventData;
	}
	*/
}
