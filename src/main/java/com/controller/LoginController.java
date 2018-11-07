package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pojo.User;
import com.service.UserService;
import com.utility.Log;
import com.validation.UserValidation;

@Controller
@SessionAttributes("user")
public class LoginController {
	private static @Log Logger LOG;
	
	@Autowired
	UserValidation validate;
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String getLoginForm() {
		return "Login";
	}
	
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request,@RequestParam String name, @RequestParam String password, @ModelAttribute User user, ModelMap map) {
		LOG.debug(validate.isUserValid(name, password));
		if (validate.isUserValid(name, password)) {
			map.put("name", name);
			user = service.getUser(name, password);
			map.addAttribute("user",user);
			//HttpSession session = request.getSession();
			//session.setAttribute("userId", user.getId());
			return "redirect:home.htm";
		} else {
			map.put("name", name);	
			map.put("errorMessage", "Invalid Credintials");
			return "Login";
		}
		
	}
}
