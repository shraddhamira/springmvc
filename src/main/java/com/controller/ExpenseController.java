package com.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.ExpenseService;
import com.service.SubCategoryService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService service;

	@Autowired
	SubCategoryService subCategoryService;

	@RequestMapping(value = "/addExpense.htm", method = RequestMethod.GET)
	public String addExpense(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("subCategoryList",
				subCategoryService.getAllSubCategories(userId));
		return "ExpenseAdd";
	}

	@RequestMapping(value = "/addExpense.htm", method = RequestMethod.POST)
	public String saveExpense(HttpServletRequest request,
			@RequestParam String description, @RequestParam Float amount,
			@RequestParam Long subCategoryId, @DateTimeFormat(pattern="yyyy-MM-dd")@RequestParam Date createDate) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		service.addExpense(description, userId, subCategoryId, amount,
				createDate);
		return "redirect:/expenses.htm";
	}

	@RequestMapping(value = "/expenses.htm", method = RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("list", this.service.getAllExpenses(userId));
		map.put("subCategoryList",
				subCategoryService.getAllSubCategories(userId));
		return "Expense";
	}
}
