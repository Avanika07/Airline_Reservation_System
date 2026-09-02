package com.airline.model;

public class Flight {
	
	    private int flightId;
	    private String flightNumber;
	    private String airlineName;
	    private String source;
	    private String destination;
	    private String date;
	    private String time;
	    private int totalSeats;
	    private int availableSeats;
	    private double price;

	    public Flight(int flightId,String flightNumber,String airlineName,String source,String destination,String date,String time,int totalSeats,int availableSeats,double price) {

	        this.flightId = flightId;
	        this.flightNumber = flightNumber;
	        this.airlineName = airlineName;
	        this.source = source;
	        this.destination = destination;
	        this.date = date;
	        this.time=time;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        this.price = price;
	    }

	    public int getFlightId() {
	        return flightId;
	    }

	    public String getFlightNumber() {
	        return flightNumber;
	    }

	    public String getAirlineName() {
	        return airlineName;
	    }

	    public String getSource() {
	        return source;
	    }

	    public String getDestination() {
	        return destination;
	    }

	    public String getDate() {
	        return date;
	    }
	    
	    public String getTime() {
	    	return time;
	    }

	    public int getTotalSeats() {
	        return totalSeats;
	    }

	    public int getAvailableSeats() {
	        return availableSeats;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setAvailableSeats(int availableSeats) {
	        this.availableSeats = availableSeats;
	    }

	    @Override
	    public String toString() {

	        return "Flight ID: " + flightId
	                + " | Flight: " + flightNumber
	                + " | Airline: " + airlineName
	                + " | " + source + " -> " + destination
	                + " | Date: " + date
	                + " | Time: " + time
	                + " | Seats: " + availableSeats
	                + " | Price: ₹" + price;
	    }
	}


