package swa.lab4.problem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import swa.lab4.problem2.domain.entity.Product;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;


	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		//restTemplate.
		//Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
		//System.out.println("Receiving message:" + greeting.getContent());
		
		//1. Add product1
		Product  p1 = new Product();
		p1.setProductId("product1");
		p1.setName("Product 1");
		p1.setDescription("product 1 description");
		p1.setPrice(150.90);
		Product product = restTemplate.getForObject("http://localhost:8080/product/add", Product.class);
		System.out.println("Receiving message:" + product.getProductId());
		
		//2. Add product2
		//3. Add product1 to the shoppingcart (with cartId=1) with quantity 3
		//4. Add product2 to the shoppingcart (with cartId=1) with quantity 2
		//5. Checkout the shoppingcart to create an order with orderId=1
		//6. Retrieve the order with orderId=1 and print it to the console

	}

}
