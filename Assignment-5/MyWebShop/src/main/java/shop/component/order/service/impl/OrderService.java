package shop.component.order.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import shop.component.order.domain.Order;
import shop.component.order.domain.service.OrderDomainService;
import shop.component.order.reository.OrderRepository;
import shop.component.order.service.IOrder;
import shop.dto.OrderCustomerDto;
import shop.dto.OrderShoppingCartDto;
import shop.dto.service.ShopDtoService;


@Service
public class OrderService  implements IOrder {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDomainService orderDomainService;	
	
	@Autowired
	ShopDtoService shopDtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public String createOrder(String customerId, String cartId) {
		OrderCustomerDto orderCustomerDto = shopDtoService.getOrderCustomerDto(customerId);
		OrderShoppingCartDto orderShoppingCartDto = shopDtoService.getOrderShoppingCartDto(cartId);
		
		Order order = orderDomainService.createOrderFromShoppingCart(orderCustomerDto, orderShoppingCartDto);
		String orderId = orderRepository.save(order).getOrderId();			
		
		publisher.publishEvent(orderDomainService.prepareEventData(orderId, orderCustomerDto, orderShoppingCartDto));
		return orderId;
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElse(null);
	}

}
