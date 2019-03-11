package com.cg.pizzaordering.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pizzaordering.beans.Customer;
import com.cg.pizzaordering.beans.Orders;
import com.cg.pizzaordering.beans.Pizza;
import com.cg.pizzaordering.exceptions.CustomerDetailsNotFoundException;
import com.cg.pizzaordering.services.PizzaOrderServices;
@RestController
public class pizzaOrderServicesController {
	@Autowired
	PizzaOrderServices pizzaOrderServices;
	@RequestMapping(value= {"/acceptCustomerDetails"},method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>acceptAssociateDetails(@ModelAttribute Customer customer){
		customer=pizzaOrderServices.acceptCustomerDetails(customer);
		return new ResponseEntity<String>("Customer Successfully added Customer Id:-"+customer.getCustomerId(), HttpStatus.OK);
	}
	@RequestMapping(value= {"/getCustomerDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<Customer>getMovieDetailsPathParam(@RequestParam int customerId) throws CustomerDetailsNotFoundException{
		return new ResponseEntity<Customer>(pizzaOrderServices.getCustomerDetails(customerId),HttpStatus.OK);
	}
	@RequestMapping(value= {"/placeOrder"},method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<Orders>placeOrder(@RequestBody int customerId,List<Pizza>pizzaList) throws CustomerDetailsNotFoundException{
		return new ResponseEntity<Orders>(pizzaOrderServices.placeOrder(customerId, pizzaList),HttpStatus.OK);
	}
}
