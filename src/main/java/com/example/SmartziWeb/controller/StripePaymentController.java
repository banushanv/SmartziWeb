package com.example.SmartziWeb.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartziWeb.model.CardDetails;
import com.example.SmartziWeb.model.Paymentform;
import com.example.SmartziWeb.service.StripeService;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;


import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@RestController
public class StripePaymentController {

	@Autowired
	StripeService paymentService;
	
	private static final Logger logger = LoggerFactory.getLogger(StripePaymentController.class);
	 
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ModelAndView showTypeForm() {
        return new ModelAndView("TokenForm", "cardDetails", new CardDetails());
    }
	
	@RequestMapping(value = "/createPayment", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("cardDetails") CardDetails card) throws StripeException {
	//	if (result.hasErrors()) {
			
	//	}
		Token token = paymentService.getToken(card);
		Paymentform form = new Paymentform();
		logger.info(token.toString());
		form.setStripeToken(token.getId());
		return new ModelAndView("PaymentForm", "paymentForm", form);
	}
	
	@RequestMapping(value = "/sendPayment", method = RequestMethod.POST)
	public ModelAndView submitPayment(@Valid @ModelAttribute("paymentForm") Paymentform payment) throws StripeException {
//		if (result.hasErrors()) {
			
	//	}
		Charge charge = paymentService.charge(payment);
		logger.info(charge.toString());
		 return new ModelAndView("completed");
	}
	
	
}