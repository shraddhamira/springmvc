package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pojo.User;
import com.service.ExpenseService;

@Controller
public class HomeController {
	
	String userId;
	
	@Autowired
	ExpenseService service;
	
	@RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public String getHomePage(ModelMap map,@ModelAttribute("user") User user){
		map.put("list", this.service.getAllExpenses());
		System.out.println("LoggedInUser"+ user);
		return "Home";
	}

}
