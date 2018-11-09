package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.service.ExpenseService;

@Controller
public class HomeController {
	
	String userId;
	
	@Autowired
	ExpenseService service;
	
	@RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, ModelMap map){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("list", this.service.getAllExpenses(userId));
		return "Home";
	}

}
