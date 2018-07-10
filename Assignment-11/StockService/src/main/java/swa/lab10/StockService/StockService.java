package swa.lab10.StockService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class StockService {
	
	Stock stock;
	StockService(){
		stock = new Stock(100001, 0);
	}
	
	@Scheduled(fixedRate = 5000)
	public Flux<Stock> generateStock() {
		stock.addQuantity(5);
		Flux<Stock> flux = Flux.just(stock);
		System.out.println("Current Stock:" + stock.getQuantity());
		return flux;
	}

}
