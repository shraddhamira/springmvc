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
		list.add(new Expense(2L,"Electricity Bill",new Date(),1002L));
	}
	
	public List<Expense> getAllExpenses(){
		return list;
	}
}
