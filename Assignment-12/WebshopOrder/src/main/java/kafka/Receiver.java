package kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics = "${app.topic.order.delivered}")
    public void orderDelivered(@Payload String order,
                        @Headers MessageHeaders headers) {
        System.out.println("[Order Service] Receive \"Order Delivered Event\"="+ order);
        headers.keySet().forEach(key -> System.out.println(key+" : "+ headers.get(key)));
    }
    
    @KafkaListener(topics = "${app.topic.outofstock}")
    public void productOutOfStock(@Payload String order,
                        @Headers MessageHeaders headers) {
    	System.out.println("[Order Service] Receive \"product out of stock event\"="+ order);
        headers.keySet().forEach(key -> System.out.println(key+" : "+ headers.get(key)));
    }

}