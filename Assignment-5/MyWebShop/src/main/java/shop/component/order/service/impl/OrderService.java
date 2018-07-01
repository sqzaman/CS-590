package shop.component.order.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.component.order.domain.Order;
import shop.component.order.domain.service.OrderDomainService;
import shop.component.order.reository.OrderRepository;
import shop.component.order.service.IOrder;
import shop.dto.OrderCustomerDto;
import shop.dto.OrderShoppingCartDto;


@Service
public class OrderService  implements IOrder {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDomainService orderDomainService;	

	@Override
	public String createOrder(String customerId, String cartId) {
		OrderCustomerDto orderCustomerDto = new OrderCustomerDto(customerId);
		OrderShoppingCartDto orderShoppingCartDto = new OrderShoppingCartDto(cartId);
		
		Order order = orderDomainService.createOrderFromShoppingCart(orderCustomerDto, orderShoppingCartDto);
		return orderRepository.save(order).getOrderId();
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElse(null);
	}

}
