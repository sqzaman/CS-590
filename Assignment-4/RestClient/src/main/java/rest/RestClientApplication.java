package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import rest.client.entity.Product;
import rest.client.entity.ShoppingCart;

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
		
		String baseUrl = "http://localhost:8080/";
		
		
		//1. Add product1
		Product p1 = new Product();
		p1.setProductId("product1");
		p1.setName("Product 1");
		p1.setDescription("Product 1 description");
		p1.setPrice(12.50);
		
		Product prod1 = restTemplate.postForObject(baseUrl +  "product/add", p1, Product.class);
		//System.out.println(prod1.getName());
		//2. Add product2
		Product p2 = new Product();
		p2.setProductId("product2");
		p2.setName("Product 2");
		p2.setDescription("Product 2 description");
		p2.setPrice(12.50);
		
		Product prod2 = restTemplate.postForObject(baseUrl +  "product/add", p2, Product.class);
		
		//3. Add product1 to the shoppingcart (with cartId=1) with quantity 3
		// shoppingCart/addItem
		//ShoppingCart sc1 = restTemplate.pos(baseUrl +  "shoppingCart/addItem?productId=" + p1.getProductId() +"&quantity=1", ShoppingCart.class);
		
		//4. Add product2 to the shoppingcart (with cartId=1) with quantity 2
		//5. Checkout the shoppingcart to create an order with orderId=1
		//6. Retrieve the order with orderId=1 and print it to the console. 

		//Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
		//System.out.println("Receiving message:" + greeting.getContent());

	}

}
