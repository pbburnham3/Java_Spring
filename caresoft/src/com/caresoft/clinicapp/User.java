package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
    protected Integer getUserId() {
    	return id;
    }
    
    protected int getUserPin() {
    	return pin;
    }
    
	// Implement a constructor that takes an ID
    public User(Integer id){
    	this.id = id;
    }
    
    
}
