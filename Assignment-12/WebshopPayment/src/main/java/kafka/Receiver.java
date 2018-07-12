package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
	
    @Autowired
    private Sender sender;

    @KafkaListener(topics = "${app.topic.order.created}")
    public void orderReceived(@Payload String order,
                        @Headers MessageHeaders headers) {
        System.out.println("[Payment Service] Order is received="+ order);
        headers.keySet().forEach(key -> System.out.println(key+" : "+ headers.get(key)));
        sender.send(order);        
    }
    
    @KafkaListener(topics = "${app.topic.outofstock}")
    public void productOutOfStock(@Payload String order,
                        @Headers MessageHeaders headers) {
        System.out.println("[Payment Service] Receive \"product out of stock event\"="+ order);
        headers.keySet().forEach(key -> System.out.println(key+" : "+ headers.get(key)));
    }

}