package com.example.SmartziWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.example.SmartziWeb.service.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(schema = "UserTypes", name = "UserTypes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
	
	private static final long serialVersionUID = 1488659908646811932L;
	
	
	

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;
	
	
	
	
	@Column(name = "First_Name")
	private String FirstName;
	
	

	@Column(name = "Last_Name")
	private String LastName;
	
	@Column(name = "email", nullable = false, unique = true)
	@NotEmpty(message = "Please provide an e-mail")
	private String Email;
	
	@Column(name = "Phone_Number")
	private int Phonenumber;
	
	@Column(name = "City")
	private String City;
	
	 @NotEmpty
	    @ValidPassword
	@Column(name = "Password")
private String Password;
	 
	 @NotEmpty
	    @ValidPassword
	@Column(name = "Confirm_Password")
	private String ConfirmPassword;
	

	
	
	

	public String getFirstName() {
		return FirstName;
	}
	
		public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		Phonenumber = phonenumber;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	 public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	
	

}
