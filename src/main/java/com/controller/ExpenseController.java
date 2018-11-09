package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService service;

	@RequestMapping(value="/addExpense.htm", method=RequestMethod.GET)
	public String addExpense(){
		return "ExpenseAdd";
	}
	
	@RequestMapping(value="/addExpense.htm", method=RequestMethod.POST)
	public String saveExpense(HttpServletRequest request,@RequestParam String description,@RequestParam String amount){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		service.addExpense(description, userId);
		return "redirect:/expenses.htm";
	}
	
	@RequestMapping(value="/expenses.htm", method=RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, ModelMap map){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("list", this.service.getAllExpenses(userId));
		return "Expense";
	}
}
