package swa.lab9.CustomerService1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController1 {
	@Autowired
	AccountFeignClient accountClient;

	@RequestMapping("/customer1/{customerid}")
	public Account getAccount(@PathVariable("customerid") String customerId) {
		Account account = accountClient.getAccount(customerId);
		return account;
	}

	@FeignClient("AccountServiceProfile")
	@RibbonClient(name="AccountServiceProfile")
	interface AccountFeignClient {
		@RequestMapping("/account/{customerid}")
		public Account getAccount(@PathVariable("customerid") String customerId);
	}
}
