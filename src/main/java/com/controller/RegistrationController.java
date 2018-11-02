package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegistrationPage(){
		return "Register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegistration(){
		return "Home";
	}
	
	
}
