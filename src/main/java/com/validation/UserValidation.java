package com.validation;

import org.springframework.stereotype.Service;

@Service
public class UserValidation {

	public boolean isUserValid(String name, String password){
		if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")){
			return true;
		}
		return false;
	}
}
