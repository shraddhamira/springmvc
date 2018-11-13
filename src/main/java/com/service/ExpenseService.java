package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.Expense;

@Service
public class ExpenseService {

	static List<Expense> list = new ArrayList<Expense>();

	static {
		list.add(new Expense(1L, "Phone Recharge", new Date(), 1001L, 1001L,230.0f));
		list.add(new Expense(2L, "Electricity Bill", new Date(), 1001L, 1001L,340f));
		list.add(new Expense(3L, "RD", new Date(), 1002L, 1001L,500f));
	}

	public List<Expense> getAllExpenses(Long userId) {
		List<Expense> listForUser = new ArrayList<Expense>();
		for (int i = 0; i < list.size(); i++) {
			Expense detail = list.get(i);
			if (detail.getUserId().equals(userId)) {
				listForUser.add(detail);
			}
		}
		return listForUser;
	}

	public void addExpense(String description, Long userId, Long subCategoryId,
			Float amount, Date createDate) {
		Expense expense = new Expense(list.size() + 1L, description,
				createDate, userId, subCategoryId, amount);
		list.add(expense);
	}
}
