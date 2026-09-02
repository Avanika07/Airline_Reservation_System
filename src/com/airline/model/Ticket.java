package com.airline.model;

public class Ticket {
	
	    private int ticketNumber;
	    private Reservation reservation;

	    public Ticket(int ticketNumber,Reservation reservation) {

	        this.ticketNumber = ticketNumber;
	        this.reservation = reservation;
	    }

	    public void displayTicket() {

	        System.out.println("\n================================");
	        System.out.println("          AIRLINE TICKET");
	        System.out.println("================================");

	        System.out.println("Ticket Number : " + ticketNumber);

	        System.out.println("Reservation ID: "+ reservation.getReservationId());

	        System.out.println("Passenger     : "+ reservation.getPassenger().getName());

	        System.out.println("Flight        : "+ reservation.getFlight().getFlightNumber());

	        System.out.println("Airline       : "+ reservation.getFlight().getAirlineName());

	        System.out.println("From          : "+ reservation.getFlight().getSource());

	        System.out.println("To            : "+ reservation.getFlight().getDestination());

	        System.out.println("Date          : "+ reservation.getFlight().getDate());

	        System.out.println("Seat Number   : "+ reservation.getSeatNumber());

	        System.out.println("Status        : "+ reservation.getStatus());

	        System.out.println("================================");
	    }
	}


