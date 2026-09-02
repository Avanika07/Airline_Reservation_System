package com.airline.model;

public class Reservation {
	
	    private int reservationId;
	    private Passenger passenger;
	    private Flight flight;
	    private int seatNumber;
	    private String status;

	    public Reservation(int reservationId,Passenger passenger,Flight flight,int seatNumber) {

	        this.reservationId = reservationId;
	        this.passenger = passenger;
	        this.flight = flight;
	        this.seatNumber = seatNumber;
	        this.status = "CONFIRMED";
	    }

	    public int getReservationId() {
	        return reservationId;
	    }

	    public Passenger getPassenger() {
	        return passenger;
	    }

	    public Flight getFlight() {
	        return flight;
	    }

	    public int getSeatNumber() {
	        return seatNumber;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void cancelReservation() {
	        status = "CANCELLED";
	    }
	}


