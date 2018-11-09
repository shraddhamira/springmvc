package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.Expense;

@Service
public class ExpenseService {

	static List<Expense> list = new ArrayList<Expense>();
	
	static{
		list.add(new Expense(1L,"Phone Recharge",new Date(),1001L));
		list.add(new Expense(2L,"Electricity Bill",new Date(),1001L));
		list.add(new Expense(3L,"Electricity Bill",new Date(),1002L));
	}
	
	public List<Expense> getAllExpenses(Long userId){
		List<Expense> listForUser = new ArrayList<Expense>();
		for (int i = 0; i < list.size(); i++) {
			Expense detail = list.get(i);
			if(detail.getUserId().equals(userId)){
				listForUser.add(detail);
			}
		}
		return listForUser;
	}
	
	public void addExpense(String description,Long userId){
		Expense expense = new Expense(list.size()+ 1L, description, new Date(), userId);
		list.add(expense);
	}
}
