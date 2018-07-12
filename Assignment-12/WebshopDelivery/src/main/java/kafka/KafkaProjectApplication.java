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

    @Override
    public void run(String... strings) throws Exception {
    }
}