package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Category;
import com.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService service;

	@RequestMapping(value="/addCategory.htm", method=RequestMethod.GET)
	public String addCategory(){
		return "CategoryAdd";
	}
	
	@RequestMapping(value="/addCategory.htm", method=RequestMethod.POST)
	public String saveCategory(HttpServletRequest request,@RequestParam String description){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		service.addCategory(description, userId);
		return "redirect:/categories.htm";
	}
	
	@RequestMapping(value="/categories.htm", method=RequestMethod.GET)
	public String getAllCategories(HttpServletRequest request, ModelMap map){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		map.put("list", this.service.getAllCategories(userId));
		return "Category";
	}
	
	
	@RequestMapping(value="/categories.json", method=RequestMethod.GET)
	@ResponseBody public List<Category> getCategories(HttpServletRequest request){
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		return this.service.getAllCategories(userId);
	}
}
