package shop.component.customer.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shop.component.customer.domain.customer.Customer;
import shop.component.customer.service.impl.CustomerService;
import shop.message.NotFoundMessage;
import shop.message.SuccessMessage;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(
			@RequestParam(value = "customerId" , required = true) final String customerId,
			@RequestParam(value = "firstName" , required = true) final String firstName,
			@RequestParam(value = "lastName", required = true) final String lastName,
			@RequestParam(value = "email", required = true) final String email,
			@RequestParam(value = "phone", required = true) final String phone
			){
		customerService.addCustomer(customerId, firstName, lastName, email, phone);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}
	
	@GetMapping("/get/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable("customerId") String customerId){
		Customer customer = customerService.getCustomer(customerId);
		if (customer != null)
		return new ResponseEntity<Customer>(customer,  HttpStatus.OK );
		else 
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no customr found"), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
	}
	
	@PostMapping("/addCreditCard")
	public ResponseEntity<?> addCreditCard(
			@RequestParam(value = "customerId" , required = true) final String customerId,
			@RequestParam(value = "cardName" , required = true) final String cardName,
			@RequestParam(value = "cardNumber" , required = true) final String cardNumber,
			@RequestParam(value = "validTill" , required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate  validTill
			) {
		customerService.addCreditCard(customerId, cardName, cardNumber, validTill);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}
	
	@PostMapping("/addBillingAddress")
	public ResponseEntity<?> addBillingAddress(
			@RequestParam(value = "customerId" , required = true) final String customerId,
			@RequestParam(value = "street" , required = true) final String street,
			@RequestParam(value = "city" , required = true) final String city,
			@RequestParam(value = "zip" , required = true) final String zip,
			@RequestParam(value = "state" , required = true) final String state,
			@RequestParam(value = "country" , required = true) final String country
			) {
		// String customerId, String street, String city, String zip, String state,		String country
		customerService.addBillingAddress(customerId, street, city, zip, state, country);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}
	
	@PostMapping("/addShippingAddress")
	public ResponseEntity<?> addShippingAddress(
			@RequestParam(value = "customerId" , required = true) final String customerId,
			@RequestParam(value = "street" , required = true) final String street,
			@RequestParam(value = "city" , required = true) final String city,
			@RequestParam(value = "zip" , required = true) final String zip,
			@RequestParam(value = "state" , required = true) final String state,
			@RequestParam(value = "country" , required = true) final String country
			) {
		customerService.addShippingAddress(customerId, street, city, zip, state, country);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}
}
