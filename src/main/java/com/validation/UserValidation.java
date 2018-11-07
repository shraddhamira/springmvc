package com.validation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.User;
import com.service.UserService;
import com.utility.Log;

@Service
public class UserValidation {
	private static @Log Logger LOG;
	
	@Autowired
	UserService service;
	
	public boolean isUserValid(String name, String password){
		User loggedInUser = service.getUser(name,password);
		LOG.debug(loggedInUser);
		if(null!=loggedInUser){
			return true;
		}
		return false;
	}
}
