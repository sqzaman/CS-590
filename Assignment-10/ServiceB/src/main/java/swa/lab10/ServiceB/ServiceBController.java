package swa.lab10.ServiceB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ServiceBController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/text")
	@HystrixCommand(fallbackMethod = "getTextFallback")
	public String getText() {
		String service3Text = restTemplate.getForObject("http://localhost:9092/text", String.class);
		return "SrviceB: " + service3Text;
	}
	public String getTextFallback() {
		return "Service C Unreachable";
	}
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
