package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.ExpenseService;

@Controller
public class AddExpenseController {
	@Autowired
	ExpenseService service;

	@RequestMapping(value="/addExpense.htm", method=RequestMethod.GET)
	public String addExpense(){
		return "AddExpense";
	}
	
	@RequestMapping(value="/addExpense.htm", method=RequestMethod.POST)
	public String saveExpense(HttpServletRequest request,@RequestParam String description,@RequestParam String amount){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		service.addExpense(description, userId);
		return "redirect:/home.htm";
	}
}
