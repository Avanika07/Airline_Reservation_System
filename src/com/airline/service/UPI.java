package com.airline.service;

public class UPI implements Payment {

	    @Override
	    public void pay(double amount) {

	        System.out.println("Payment of ₹" + amount + " completed using UPI.");
	    }
	}

