package swa.lab10.StockService;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class StockServiceClientApplication {

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(StockServiceClientApplication.class, args);

		Flux<Stock> result = WebClient.create("http://localhost:8080/stock").get().retrieve()
				.bodyToFlux(Stock.class);
		result.subscribe(s -> {
			System.out.print(LocalDateTime.now() + " : ");
			System.out.println("Current Stock at client: " + s.getQuantity());
		});
		Thread.sleep(15000);
	}

}
