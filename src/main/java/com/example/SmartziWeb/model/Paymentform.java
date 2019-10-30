package com.example.SmartziWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(schema = "PaymentTypes", name = "PaymentTypes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paymentform implements Serializable {

	private static final long serialVersionUID = 1488659908646811933L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;
	
	
	@Column(name="Description")
    private String description;
    
	@Column(name="Amount")
    private int amount;
    
	@Column(name="Currency")
    private String currency;
   
    
	@Column(name="Stripe_Email")
    private String stripeEmail;
    
	@Column(name="Stripe_Token")
    private String stripeToken;
    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStripeEmail() {
		return stripeEmail;
	}
	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}
	public String getStripeToken() {
		return stripeToken;
	}
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
	@Override
	public String toString() {
		return "PaymentRequest [description=" + description + ", amount=" + amount + ", currency=" + currency
				+ ", stripeEmail=" + stripeEmail + ", stripeToken=" + stripeToken + "]";
	}
}