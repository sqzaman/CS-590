package swa.lab4.problem2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swa.lab4.problem2.domain.entity.Order;
import swa.lab4.problem2.domain.entity.ShoppingCart;
import swa.lab4.problem2.domain.service.OrderDomainService;
import swa.lab4.problem2.repository.OrderRepository;
import swa.lab4.problem2.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderDomainService orderDomainService;
	
	@Override
	public Order createOrder(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		Order order = orderDomainService.createOrderFormCart(shoppingCart);
		return orderRepo.save(order);
		
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderRepo.findById(orderId).orElse(null);
	}

	@Override
	public void createOrder(String orderId, ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		Order order = orderDomainService.createOrderFormCart(orderId, shoppingCart);
		orderRepo.save(order);
	}

}
