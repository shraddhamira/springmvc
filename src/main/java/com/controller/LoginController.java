package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.validation.UserValidation;

@Controller
public class LoginController {
	
	@Autowired
	UserValidation validate;
	
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	//@ResponseBody public String sayHello() {
	//	return "Hello World";
	//}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String getLoginForm() {
		return "Login";
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String doLogin(@RequestParam String name, @RequestParam String password, ModelMap map) {
		//String name = request.getParameter("name");
		//String password = request.getParameter("password");
		if (null != name && validate.isUserValid(name, password)) {
			//request.setAttribute("name", name);
			map.put("name", name);
			return "Home";
		} else {
			map.put("name", name);	
			map.put("errorMessage", "Invalid Credintials");
			return "Login";
		}
		
	}
}
