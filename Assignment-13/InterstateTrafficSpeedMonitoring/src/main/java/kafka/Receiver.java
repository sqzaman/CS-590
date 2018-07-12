package kafka;

import java.util.Random;

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
	
	
	private int topicNum = 1;
	
	private Random ran;   
    private int maximum = 100;
    private int minimum = 40;
    private int range = 0;
    
	Receiver(){
		ran = new Random();
		range = maximum - minimum + 1;
	}

	
    @KafkaListener(id= "1", topics = {"cameratopic1" , "cameratopic2"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {
    	  
        int randomNum =  ran.nextInt(range) + minimum;
        String speedTopic = "speed_topic_" + topicNum++;
   
        sender.send(speedTopic, new SpeedRecord(sensorRecord.getLicencePlate(), randomNum));
        if(topicNum > 2) {
        	topicNum = 1;
        }
    	
        //System.out.println("received message="+ sensorRecord.toString());

      
    }
}
