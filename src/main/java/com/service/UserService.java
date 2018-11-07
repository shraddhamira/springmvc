package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.User;

@Service
public class UserService {
	static List<User> list = new ArrayList<User>();
	static {
		list.add(new User(1001L, "admin1", "password", new Date()));
		list.add(new User(1001L, "admin2", "password", new Date()));
	}

	public List<User> getAllUsers() {
		return list;
	}

	public void addUser(User user) {
		list.add(user);
	}

	public void updateUser(User user) {
		for (User userDetail : list) {
			if (user.equals(userDetail)) {
				userDetail.copyFrom(user);
			}
		}
	}

	public void deleteUser(User user) {
		for (User userDetail : list) {
			if (user.equals(userDetail)) {
				list.remove(userDetail);
				break;
			}
		}
	}

	public User getUser(Long id) {
		for (User userDetail : list) {
			if (id.equals(userDetail.getId())) {
				return userDetail;
			}
		}
		return null;
	}

	public User getUser(String userName, String password) {
		for (User userDetail : list) {
			if (userName.equalsIgnoreCase(userDetail.getUserName())
					&& password.equalsIgnoreCase(userDetail.getPassword())) {
				return userDetail;
			}
		}
		return null;
	}

}
