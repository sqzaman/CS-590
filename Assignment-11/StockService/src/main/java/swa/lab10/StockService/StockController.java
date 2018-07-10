package swa.lab10.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.util.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StockController {

	@Autowired
	StockService stockService;

	@GetMapping(value="/stock", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Stock> getStock() {
		//Mono<Stock> mono = Mono.just(stockService.generateStock()).delayElement((Durations.ofSeconds(15));
		// .delayElement(Duration.ofSeconds(5));
		 Flux<Stock> flux = Flux.concat(stockService.generateStock());
		return flux;
	}
}
