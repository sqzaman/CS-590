package swa.lab8.AuthenticationTestServiceA;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	@Autowired
	OAuth2RestTemplate restTemplate;

	@GetMapping("/product")
	public Map<String, String> getProduct() {
		Map<String, String> productMap = new HashMap<>();
		productMap.put("prod-001", "Television");
		productMap.put("prod-002", "Refrigerator");
		return productMap;
	}

	@GetMapping("/salary")
	public String getGetSalary() {
		return "95.000";
	}

	@GetMapping("/contact")
	public String getContact() {
		return restTemplate.getForObject("http://localhost:8091/contact", String.class);
	}
}
