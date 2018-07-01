package shop.component.order.domain.service;

import shop.component.order.domain.Order;
import shop.component.order.domain.OrderAddress;
import shop.component.order.domain.OrderCreditCard;
import shop.component.order.domain.OrderCustomer;
import shop.component.order.domain.OrderItem;
import shop.dto.OrderCustomerDto;
import shop.dto.OrderShoppingCartDto;
import shop.util.Helper;

public class OrderDomainService {
	public Order createOrderFromShoppingCart(OrderCustomerDto orderCustomerDto,
			OrderShoppingCartDto orderShoppingCartDto) {

		Order order = new Order();

		order.setOrderId(Helper.getInstance().generateRandomString());
		order.setCustomer(new OrderCustomer(orderCustomerDto.getCustomerId(), orderCustomerDto.getFirstName(),
				orderCustomerDto.getLastName(), orderCustomerDto.getEmail(), orderCustomerDto.getPhone()));

		order.setCreditCard(new OrderCreditCard(orderCustomerDto.getCreditCard().getCardName(),
				orderCustomerDto.getCreditCard().getCardNumber()));

		order.setBillingAddress(orderCustomerDto.getOrderBillingAddress());
		order.setShippingAddress(orderCustomerDto.getOrderShippingAddress());

		for (OrderItem orderItem : orderShoppingCartDto.getOrderItems()) {
			order.addOrderItem(orderItem);
		}

		return order;
	}
}
