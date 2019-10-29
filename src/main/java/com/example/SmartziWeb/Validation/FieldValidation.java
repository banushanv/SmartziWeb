package com.example.SmartziWeb.Validation;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.SmartziWeb.exception.CrossSellBannerBadRequestException;
import com.example.SmartziWeb.model.User;



@Component
public class FieldValidation {
	private static final Logger logger = LogManager.getLogger(FieldValidation.class);
	
	
	public boolean validateUploadCrossSellBanners(User model) {

		
		String email=model.getEmail();
		String password=model.getPassword();
		String passwordmatch=model.getConfirmPassword();
		
		
		
		if ((StringUtils.isEmpty(StringUtils.isEmpty(email))|| StringUtils.isEmpty(password)) && (StringUtils.pathEquals(password, passwordmatch)) ){
			logger.error("BAD REQUEST :Check the payload again");	
			throw new CrossSellBannerBadRequestException("BAD REQUEST :Check the payload again");
		}
		
	
		
		else{
			logger.info("Banner validation is successful");	
			return true;
		}
}
}
