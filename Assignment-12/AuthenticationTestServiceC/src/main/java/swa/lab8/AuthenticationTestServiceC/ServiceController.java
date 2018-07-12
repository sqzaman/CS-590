package swa.lab8.AuthenticationTestServiceC;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	@GetMapping("/salary")
	public String getContact() {
		return "USD 4500.00";
	}
}
