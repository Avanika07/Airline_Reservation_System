package com.airline.service;

public class PaymentService {

	    public boolean processPayment(double amount,int paymentChoice) {

	        Payment payment;

	        if (paymentChoice == 1) {

	            payment = new UPI();

	        } else if (paymentChoice == 2) {

	            payment = new CreditCard();

	        } else {

	            System.out.println("Invalid payment method.");

	            return false;
	        }

	        payment.pay(amount);

	        return true;
	    }
	}

