package com.example.SmartziWeb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SmartziWeb.model.CardDetails;
import com.example.SmartziWeb.model.Paymentform;
import com.example.SmartziWeb.model.dto.SuccessResponse;
import com.example.SmartziWeb.repository.PaymentRepository;
import com.example.SmartziWeb.service.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;


@Service
public class StripeServiceImpl implements StripeService{
	@Autowired
	private PaymentRepository paymetRepository;

	@Override
	public ResponseEntity charge(Paymentform payment) throws StripeException {
		SuccessResponse response= new SuccessResponse();
		Stripe.apiKey = "Your stripe secret key";
		
		Map<String, Object> chargeParams = new HashMap<>();
	        chargeParams.put("amount", payment.getAmount());
	        chargeParams.put("currency", payment.getCurrency());
	        chargeParams.put("description", payment.getDescription());
	        chargeParams.put("source", payment.getStripeToken());
	        payment.equals(chargeParams);
	        this.paymetRepository.save(payment);
	        response.setStatus("200");
			response.setDescription("uploading banner is successful ");
			return new ResponseEntity(response, HttpStatus.OK);
	       // return Charge.create(chargeParams);
	}

	@Override
	public Token getToken(CardDetails card) throws StripeException {
		Stripe.apiKey = "Your stripe secret key";
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.put("number", card.getCardNumber());
		cardParams.put("exp_month", card.getExpMonth());
		cardParams.put("exp_year", card.getExpYear());
		cardParams.put("cvc", card.getCsv());
		
		Map<String, Object> tokenParams = new HashMap<String, Object>();
		tokenParams.put("card", cardParams);
		Token token = Token.create(tokenParams);
		return token;
	}

}