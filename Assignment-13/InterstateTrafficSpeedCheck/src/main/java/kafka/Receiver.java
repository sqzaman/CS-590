package kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {


	@KafkaListener(id= "1", topics = { "speed_topic_1", "speed_topic_2" })
	public void receive(@Payload SpeedRecord speedRecord, @Headers MessageHeaders headers) {
		if (speedRecord.getSpeed() > 71 && speedRecord.getSpeed() < 78) {
			System.out.println(String.format(
					"Car: %s, breaks speed limit, speed recorded %s miles/hour. $25 fine ticket sent to car owner!",
					speedRecord.getLicencePlate(), speedRecord.getSpeed()));
		} else if (speedRecord.getSpeed() > 77 && speedRecord.getSpeed() < 83) {
			System.out.println(String.format(
					"Car: %s, breaks speed limit, speed recorded %s miles/hour. $45 fine ticket sent to car owner!",
					speedRecord.getLicencePlate(), speedRecord.getSpeed()));
		} else if (speedRecord.getSpeed() > 82 && speedRecord.getSpeed() < 91) {
			System.out.println(String.format(
					"Car: %s, breaks speed limit, speed recorded %s miles/hour. $80 fine ticket sent to car owner!",
					speedRecord.getLicencePlate(), speedRecord.getSpeed()));
		} else if (speedRecord.getSpeed() > 90) {
			System.out.println(String.format(
					"Car: %s, breaks speed limit, speed recorded %s miles/hour. $125 fine ticket sent to car owner!",
					speedRecord.getLicencePlate(), speedRecord.getSpeed()));
		}
	}
}
