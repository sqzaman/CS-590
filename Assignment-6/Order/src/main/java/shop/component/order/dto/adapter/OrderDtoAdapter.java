package shop.component.order.dto.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import shop.component.order.domain.Order;
import shop.component.order.domain.OrderAddress;
import shop.component.order.domain.OrderCreditCard;
import shop.component.order.domain.OrderCustomer;
import shop.component.order.domain.OrderItem;
import shop.component.order.domain.OrderProduct;
import shop.component.order.dto.CartItemDto;
import shop.component.order.dto.CreditCardDto;
import shop.component.order.dto.OrderAddressDto;
import shop.component.order.dto.OrderCustomerDto;
import shop.component.order.dto.OrderDto;
import shop.component.order.dto.OrderShoppingCartDto;
import shop.component.order.dto.ShoppingProductDto;


@Service
public class OrderDtoAdapter {


	public OrderCustomerDto getOrderCustomerDto(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		OrderCustomerDto orderCustomerDto = restTemplate
				.getForObject("http://localhost:8083/customer/get/" + customerId, OrderCustomerDto.class);
		System.out.println("CustomerId: "+customerId);
		return orderCustomerDto;
	}

	public OrderCustomer getOrderCustomer(OrderCustomerDto orderCustomerDto) {
		return new OrderCustomer(orderCustomerDto.getCustomerId(), orderCustomerDto.getFirstName(),
				orderCustomerDto.getLastName(), orderCustomerDto.getEmail(), orderCustomerDto.getPhone());
	}
	
	public List<OrderItem> getOrderItems(List<CartItemDto> cartItems) {
		List<OrderItem> orderItems = new ArrayList<>();
		
		for(CartItemDto cartItemDto: cartItems) {
			orderItems.add(
							new OrderItem(new OrderProduct(
									cartItemDto.getProduct().getProductId(),
									cartItemDto.getProduct().getName(),
									cartItemDto.getProduct().getPrice()
									),
							cartItemDto.getQuantity()
						)
					);
		}		
		
		return orderItems;
	}
	
	public OrderCreditCard getOrderCreditCard(CreditCardDto creditCardDto) {
		return new OrderCreditCard(creditCardDto.getCardName(), creditCardDto.getCardNumber());
	}
	
	public OrderAddress getOrderBillingAddress(OrderCustomerDto orderCustomerDto) {
		OrderAddressDto orderAddressDto = orderCustomerDto.getBillingAddress();
		return new OrderAddress(orderAddressDto.getStreet(), 
				orderAddressDto.getCity(), orderAddressDto.getZip(),
				orderAddressDto.getState(), orderAddressDto.getCountry()
				);
	}
	
	public OrderAddress getOrderShippingAddress(OrderCustomerDto orderCustomerDto) {
		OrderAddressDto orderAddressDto = orderCustomerDto.getShippingAddress();
		return new OrderAddress(orderAddressDto.getStreet(), 
				orderAddressDto.getCity(), orderAddressDto.getZip(),
				orderAddressDto.getState(), orderAddressDto.getCountry()
				);
	}



	public OrderDto getOrderDto(Order order) {
		return new OrderDto(order.getOrderId());
	}
}
