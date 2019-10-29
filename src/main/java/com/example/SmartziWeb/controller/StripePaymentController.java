package com.example.SmartziWeb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartziWeb.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;



@RestController
@RequestMapping(path = "/api/pay")
public class StripePaymentController {
	
	@GetMapping("/stripe")
	public ResponseEntity sample() throws StripeException {
		Stripe.apiKey="sk_test_z31ZERwfxqqfMJdbx0WpeoGa";
		Map<String,Object> cardParam=new HashMap<String,Object>();
		
		Map<String,Object> customerParameter=new HashMap<String,Object>();
		
		customerParameter.put("email", "sanu@gmail.com");
		Customer newCustomer=Customer.create(customerParameter);
	//	Customer a=Customer.retrieve("cus_G4YkPdSCIMIM9L");
		Customer b=Customer.retrieve("cus_G4Zx5B4rfNDusg");
		
		
		
		
		cardParam.put("number", "4242 4242 4242 4242");
		cardParam.put("exp_month", "11");
		cardParam.put("exp_year", "2021");
		cardParam.put("cvc", "111");
		
		Map<String,Object> tokenParam=new HashMap<String,Object>();
		tokenParam.put("card",cardParam);
		
		Token token=Token.create(tokenParam);
		
		Map<String,Object> source=new HashMap<String,Object>();
		
		source.put("source",token.getId());
		b.getSources().create(source);
		
		Map<String,Object> chargeParam=new HashMap<String,Object>();
		chargeParam.put("amount", 300);
		chargeParam.put("currency", "usd");
		chargeParam.put("customer", b.getId());
		
		
		Charge.create(chargeParam);
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(b));
		  return new ResponseEntity<String>("Account Created",HttpStatus.OK);
//		System.out.println(newCustomer.getId());
	}

	
	
	
			
		
	}
	
	


