package swa.lab3.problem1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@RequestMapping("/greeting/{message}")
	public ResponseEntity<?> getGreeting(@PathVariable("message") String message){
		Greeting gr = new Greeting(message);
		return new ResponseEntity<Greeting>(gr, HttpStatus.OK);
	}
}
