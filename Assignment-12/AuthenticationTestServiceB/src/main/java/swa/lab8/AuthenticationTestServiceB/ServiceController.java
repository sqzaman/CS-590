package swa.lab8.AuthenticationTestServiceB;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	@GetMapping("/contact")
	public String getContact() {
		return "+19345453453";
	}
}
