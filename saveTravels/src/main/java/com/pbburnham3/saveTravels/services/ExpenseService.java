package com.pbburnham3.saveTravels.services;

import java.util.List;
import java.util.Optional;

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
	
	// returns all expenses
	public List<Expense> allExpenses() {
	    return expenseRepository.findAll();
	}
	
	// creates an expense
	public Expense createExpense(Expense b) {
	    return expenseRepository.save(b);
	}
	
	
	// retrieves a book
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
		    return optionalExpense.get();
		} else {
		    return null;
		}
	}
	
	// updates an expense
	public Expense updateExpense(Expense expense) {
		
		return expenseRepository.save(expense);
	}
	
	// deletes an expense
	public Expense deleteExpense(Long id) {
		expenseRepository.deleteById(id);
		return null;
	}

}
