package com.airline.service;

import java.util.ArrayList;

import com.airline.model.Flight;

public class FlightService {
	
	    private ArrayList<Flight> flights = new ArrayList<>();

	    public void addFlight(Flight flight) {

	        flights.add(flight);

	        System.out.println("Flight added successfully.");
	    }

	    public void displayFlights() {

	        if (flights.isEmpty()) {

	            System.out.println("No flights available.");

	            return;
	        }

	        System.out.println("\n========== AVAILABLE FLIGHTS ==========");

	        for (Flight flight : flights) {
	            System.out.println(flight);
	        }

	        System.out.println("========================================");
	    }

	    public void searchFlight(String source,String destination) {

	        boolean found = false;

	        for (Flight flight : flights) {

	            if (flight.getSource().equalsIgnoreCase(source)&&flight.getDestination().equalsIgnoreCase(destination)) {

	                System.out.println(flight);

	                found = true;
	            }
	        }

	        if (!found) {

	            System.out.println("No flights found.");
	        }
	    }

	    public Flight getFlightById(int flightId) {

	        for (Flight flight : flights) {

	            if (flight.getFlightId() == flightId) {

	                return flight;
	            }
	        }

	        return null;
	    }
	}


