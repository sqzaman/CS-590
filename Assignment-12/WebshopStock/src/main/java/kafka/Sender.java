package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.order.prepared}")
    private String topicToDelivery;
    
    @Value("${app.topic.outofstock}")
    private String topicOutOfStock;

    public void sendToDelivery(String order){
    	System.out.println("[Stock Service] Order="+ order);
        System.out.println("is sending to Delivery with topic="+ topicToDelivery);
    	kafkaTemplate.send(topicToDelivery, order);
    }
    
    public void sendToOutOfStock(String order){
    	System.out.println("[Stock Service] Order="+ order);
        System.out.println("is sending OutOfStock topic="+ topicOutOfStock);
    	kafkaTemplate.send(topicOutOfStock, order);
    }
}
