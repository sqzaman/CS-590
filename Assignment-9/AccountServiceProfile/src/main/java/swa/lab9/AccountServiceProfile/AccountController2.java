package swa.lab9.AccountServiceProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Two")
public class AccountController2 {
	@RequestMapping("/account/{customerid}")
	public Account getAccount(@PathVariable("customerid") String customerId) {
		return new Account("1234", 2000.00);
	}
}
