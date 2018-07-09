package swa.lab9.AccountServiceProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceProfileApplication.class, args);
	}
}
