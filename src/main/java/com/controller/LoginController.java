package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.utility.Log;
import com.validation.UserValidation;

@Controller
public class LoginController {
	private static @Log Logger LOG;
	
	@Autowired
	UserValidation validate;
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String getLoginForm() {
		return "Login";
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String doLogin(@RequestParam String name, @RequestParam String password, ModelMap map) {
		LOG.debug(validate.isUserValid(name, password));
		if (validate.isUserValid(name, password)) {
			map.put("name", name);
			return "redirect:home.htm";
		} else {
			map.put("name", name);	
			map.put("errorMessage", "Invalid Credintials");
			return "Login";
		}
		
	}
}
