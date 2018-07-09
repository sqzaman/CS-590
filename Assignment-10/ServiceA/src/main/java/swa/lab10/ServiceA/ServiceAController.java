package swa.lab10.ServiceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ServiceAController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/text")
	@HystrixCommand(fallbackMethod = "getTextFallback")
	public String getText() {
		String service2Text = restTemplate.getForObject("http://localhost:9091/text", String.class);
		return "Hello " + service2Text;
	}

	public String getTextFallback() {
		return "Service B Unreachable";
	}

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
