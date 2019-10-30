package com.example.SmartziWeb.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.SmartziWeb.model.CardDetails;
import com.example.SmartziWeb.model.Paymentform;

import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;


import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Token;

@Service
public interface StripeService {
	public Charge charge(Paymentform payment) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException, StripeException;
	public Token getToken(CardDetails card) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException, StripeException;
}