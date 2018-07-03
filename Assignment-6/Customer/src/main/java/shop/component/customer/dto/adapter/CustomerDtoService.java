package shop.component.customer.dto.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.component.customer.domain.Customer;
import shop.component.customer.dto.OrderCustomerDto;
import shop.component.customer.service.impl.CustomerService;

@Service
public class CustomerDtoService {
	
	@Autowired
	CustomerService customerService;


	
	public OrderCustomerDto getOrderCustomerDto(String customerId) {
		return new OrderCustomerDto(customerService.getCustomer(customerId));
	}

}
