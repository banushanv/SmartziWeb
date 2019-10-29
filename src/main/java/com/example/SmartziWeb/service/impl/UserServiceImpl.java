package com.example.SmartziWeb.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.SmartziWeb.exception.BadRequestException;
import com.example.SmartziWeb.exception.ServiceException;
import com.example.SmartziWeb.model.User;
import com.example.SmartziWeb.model.dto.SuccessResponse;
import com.example.SmartziWeb.model.dto.UserDto;
import com.example.SmartziWeb.repository.UserRepository;
import com.example.SmartziWeb.service.UserService;





@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public ResponseEntity userRegister(UserDto argType) {
		logger.info("Adding new User");
		SuccessResponse response= new SuccessResponse();
		try {
		User modle= new User(); 
		

		modle.setCity(argType.getCity());
		modle.setEmail(argType.getEmail());
		modle.setFirstName(argType.getFirstName());
		modle.setLastName(argType.getLastName());
		modle.setPassword(argType.getPassword());
		modle.setConfirmPassword(argType.getConfirmPassword());
		modle.setPhonenumber(argType.getPhonenumber());
		
		
			
		
			
			this.userRepository.save(modle);
			logger.info("Registering user is successful");
			response.setDescription("User Registration is successful");
			response.setStatus("200");
			return new ResponseEntity(response, HttpStatus.OK);
			
	}catch(IndexOutOfBoundsException e) {
		logger.error("index out of bound  ", e);
		response.setDescription("index out of bound  ");
		response.setStatus("500");
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}catch(NumberFormatException e) {
		logger.error("Invalid agreement code or Invalid Email ",e);
		response.setDescription("Invalid agreement code or Invalid Email ");
		response.setStatus("500");
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}catch(BadRequestException e) {
		logger.error(e.getErrorMessage(),e);
		response.setDescription(e.getErrorMessage());
		response.setStatus("400");
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
			
	}catch(ServiceException e) {
		logger.error(e.getErrorMessage(),e);
		response.setStatus(Integer.toString(e.getStatus().value()));
		response.setDescription(e.getErrorMessage());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		
	}catch(Exception e ) {
		logger.error("error occured while Registering Smartzi ",e);
		response.setDescription("error occured while Registering Smartzi");
		response.setStatus("500");
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	}
	
	
	

	
	@Override 
	
	public ResponseEntity getUsersLogin(String Email,String Password) {
		SuccessResponse responses1 = new SuccessResponse();
		
			User at;
			try {
			List<User> list = this.userRepository.findTemplate(Email,Password);
			if(!list.isEmpty()) {
			at = list.get(0);
	        }else {
	        	throw new NoResultException("No User exists");
	        
	        }
			responses1.setDescription("Login SuccessFul");
			responses1.setStatus("200");
			return new ResponseEntity(responses1, HttpStatus.OK);
			
			}
	catch(NoResultException e) {
		logger.error("no entity exists ",e);
		responses1.setDescription(" no entity exists");
		responses1.setStatus("500");
		return new ResponseEntity(responses1, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}catch (Exception e) {
		logger.error("error occured ",e);
		responses1.setDescription("error occured ");
		responses1.setStatus("500");
		return new ResponseEntity(responses1, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
}
	
	
	
	

	}
	
	
