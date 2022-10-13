package com.pbburnham3.saveTravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pbburnham3.saveTravels.models.Expense;
import com.pbburnham3.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// adding the expense repository as a dependency
	private final ExpenseRepository expenseRepository;
	 
	public ExpenseService(ExpenseRepository expenseRepository) {
	    this.expenseRepository = expenseRepository;
	}
	
	// returns all the books
	public List<Expense> allExpenses() {
	    return expenseRepository.findAll();
	}
	
	// creates a book
	public Expense createExpense(Expense b) {
	    return expenseRepository.save(b);
	}

}
