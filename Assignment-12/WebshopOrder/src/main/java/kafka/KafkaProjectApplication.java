package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProjectApplication.class, args);
    }

    @Autowired
    private Sender sender;

    @Override
    public void run(String... strings) throws Exception {
        sender.send((new Order("001", 50, 100.5)).toString());
        //sender.send(new Order("002", 500, 1000.5));
    }
}