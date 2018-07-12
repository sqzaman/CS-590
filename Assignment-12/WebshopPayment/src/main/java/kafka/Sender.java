package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.order.billed}")
    private String topic;

    public void send(String order){
    	System.out.println("[Payment Service] Order="+ order);
        System.out.println("is sending to topic="+ topic);
    	kafkaTemplate.send(topic, order);
    }
}
