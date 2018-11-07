package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.ExpenseService;

@Controller
public class HomeController {
	
	@Autowired
	ExpenseService service;
	
	@RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public String getHomePage(ModelMap map){
		map.put("list", this.service.getAllExpenses());
		System.out.println(this.service.getAllExpenses());
		return "Home";
	}

}
