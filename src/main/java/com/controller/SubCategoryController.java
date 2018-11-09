package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.CategoryService;
import com.service.SubCategoryService;

@Controller
public class SubCategoryController {
	@Autowired
	SubCategoryService service;
	
	@Autowired
	private CategoryService parentService;

	@RequestMapping(value = "/addSubCategory.htm", method = RequestMethod.GET)
	public String addSubCategory(HttpServletRequest  request, ModelMap map) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("categoryList", this.parentService.getAllCategories(userId));
		return "SubCategoryAdd";
	}

	@RequestMapping(value = "/addSubCategory.htm", method = RequestMethod.POST)
	public String saveSubCategory(HttpServletRequest request, @RequestParam String description,
			@RequestParam Long parentCategoryId) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		service.addSubCategory(description, parentCategoryId, userId);
		return "redirect:/subCategories.htm";
	}

	@RequestMapping(value = "/subCategories.htm", method = RequestMethod.GET)
	public String getAllSubCategories(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("list", this.service.getAllSubCategories(userId));
		map.put("categoryList", this.parentService.getAllCategories(userId));
		return "SubCategory";
	}
}
