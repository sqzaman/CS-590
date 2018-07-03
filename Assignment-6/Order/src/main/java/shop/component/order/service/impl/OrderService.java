package shop.component.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import shop.component.order.domain.Order;
import shop.component.order.domain.OrderCustomer;
import shop.component.order.domain.service.OrderDomainService;
import shop.component.order.dto.OrderCustomerDto;
import shop.component.order.dto.OrderDto;
import shop.component.order.dto.OrderShoppingCartDto;
import shop.component.order.dto.OrderShoppingCartDto;
import shop.component.order.dto.adapter.OrderDtoAdapter;
import shop.component.order.reository.OrderRepository;
import shop.component.order.service.IOrder;

@Service
public class OrderService implements IOrder {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDomainService orderDomainService;

	@Autowired
	OrderDtoAdapter orderDtoAdapter;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public String createOrder(String customerId, String cartId) {
		/*
		 * OrderCustomerDto orderCustomerDto =
		 * shopDtoService.getOrderCustomerDto(customerId); OrderShoppingCartDto
		 * orderShoppingCartDto = shopDtoService.getOrderShoppingCartDto(cartId);
		 * 
		 * Order order =
		 * orderDomainService.createOrderFromShoppingCart(orderCustomerDto,
		 * orderShoppingCartDto); String orderId =
		 * orderRepository.save(order).getOrderId();
		 * 
		 * publisher.publishEvent(orderDomainService.prepareEventData(orderId,
		 * orderCustomerDto, orderShoppingCartDto)); return orderId;
		 */
		return null;
	}

	public Order createOrder(OrderShoppingCartDto shoppingCartDto) {
		System.out.println("CustomerID: " + shoppingCartDto.getCustomerId());
		System.out.println("=====================================================");
		OrderCustomerDto orderCustomerDto = orderDtoAdapter.getOrderCustomerDto(shoppingCartDto.getCustomerId());
		System.out.println(orderCustomerDto);
		Order order = orderDomainService.createOrder(orderDtoAdapter.getOrderCustomer(orderCustomerDto),
				orderDtoAdapter.getOrderItems(shoppingCartDto.getCartItems()),
				orderDtoAdapter.getOrderCreditCard(orderCustomerDto.getCreditCards().get(0)),
				orderDtoAdapter.getOrderBillingAddress(orderCustomerDto),
				orderDtoAdapter.getOrderShippingAddress(orderCustomerDto));

		order = orderRepository.save(order);

		return order;

	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElse(null);
	}

}
