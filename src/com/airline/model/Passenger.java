package com.airline.model;

public class Passenger extends User {

	    private String name;
	    private int age;
	    private String gender;
	    private String phone;

	    public Passenger(int userId,String username,String password,String name,int age,String gender,String phone) {

	        super(userId, username, password);

	        this.name = name;
	        this.age = age;
	        this.gender = gender;
	        this.phone = phone;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void displayPassenger() {

	        System.out.println("Passenger ID : " + getUserId());
	        System.out.println("Name         : " + name);
	        System.out.println("Age          : " + age);
	        System.out.println("Gender       : " + gender);
	        System.out.println("Phone        : " + phone);
	    }
	}


