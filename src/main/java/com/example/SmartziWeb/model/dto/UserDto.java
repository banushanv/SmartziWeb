package com.example.SmartziWeb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {

	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	private String FirstName;
	private String LastName;
	private String Email;
	private int Phonenumber;
	private String City;
	private String Password;
	private String ConfirmPassword;


}
