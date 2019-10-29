package com.example.SmartziWeb.controller;

import java.util.UUID;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartziWeb.model.dto.UserDto;
import com.example.SmartziWeb.service.UserService;
import com.example.SmartziWeb.service.impl.UserServiceImpl;
import com.example.SmartziWeb.utils.ApplicationUtils;
import com.example.SmartziWeb.utils.JacksonConfig;

import org.springframework.beans.factory.annotation.Autowired;




@RestController
@RequestMapping(path = "/api/save")
public class UserController {
	private static Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	
	
	@Autowired
	private JacksonConfig jacksonConfig;
	
	String user = "TEST";
	

	
	@PostMapping(path = "/register", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity userRegister(@RequestBody UserDto agrType) {


		long startTime = System.currentTimeMillis();

		// Add Logging context information
		ThreadContext.put("id", UUID.randomUUID().toString());
		ThreadContext.put("apiName", "/api/save/saved");
		ThreadContext.put("user", user);

		logger.info("START : Controller : Register a new User : argType "+jacksonConfig.convertToJson(agrType));

		ResponseEntity response = userService.userRegister(agrType);
	
		logger.info("RESPONSE : " + jacksonConfig.convertToJson(response.getBody()));
		logger.debug("END : Controller POST method : Elapsed Time (ms)= " + ApplicationUtils.getTimeDiff(startTime));
		ThreadContext.clearMap();
		return response;
	}
	

	
	@GetMapping(path = "/login/{ema}/{pass}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity getUserLogin(@PathVariable(name = "ema") String Email,@PathVariable(name = "pass") String Password) {
		long startTime = System.currentTimeMillis();

		// Add Logging context information
		ThreadContext.put("id", UUID.randomUUID().toString());
		ThreadContext.put("apiName", "/api/save/login/{ema}/{pass}");
		ThreadContext.put("user", user);

		logger.info("START : Controller : Getting All Agreement Type List");
		
		ResponseEntity at = this.userService.getUsersLogin(Email,Password);
		
		logger.info("RESPONSE : " + jacksonConfig.convertToJson(at.getBody()));
		logger.debug("END : Controller GET method : Elapsed Time (ms)= " + ApplicationUtils.getTimeDiff(startTime));
		ThreadContext.clearMap();
		return at;
	}
	
	
	
	
	
	
	
	
	
	}


