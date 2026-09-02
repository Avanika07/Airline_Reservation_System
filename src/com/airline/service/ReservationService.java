package com.airline.service;

import java.util.ArrayList;

import com.airline.exception.SeatNotAvailableException;
import com.airline.model.Flight;
import com.airline.model.Passenger;
import com.airline.model.Reservation;

public class ReservationService {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    private int reservationId = 1001;

    public Reservation bookTicket(Passenger passenger,Flight flight,int seatNumber)throws SeatNotAvailableException {

        // Check whether seats are available
        if (flight.getAvailableSeats() <= 0) {

            throw new SeatNotAvailableException("No seats are available on this flight.");
        }

        // Check whether seat number is valid
        if (seatNumber <= 0 || seatNumber > flight.getTotalSeats()) {

            throw new SeatNotAvailableException("Invalid seat number.");
        }

        // Check whether selected seat is already booked
        for (Reservation r : reservations) {

            if (r.getFlight().getFlightId()== flight.getFlightId() && r.getSeatNumber() == seatNumber && r.getStatus().equals("CONFIRMED")) {
            	
            	throw new SeatNotAvailableException("Seat " + seatNumber + " is already booked.");
            }
        }

        Reservation reservation = new Reservation(reservationId++,passenger,flight,seatNumber);

        reservations.add(reservation);

        flight.setAvailableSeats(flight.getAvailableSeats() - 1);

        System.out.println("Ticket booked successfully.");

        System.out.println("Reservation ID: " + reservation.getReservationId());

        return reservation;
    }
    
    public void displayReservations() {

        if (reservations.isEmpty()) {

            System.out.println("No reservations found.");

            return;
        }

        System.out.println("\n========== RESERVATIONS ==========");

        for (Reservation reservation : reservations) {

            System.out.println("Reservation ID: "+ reservation.getReservationId());

            System.out.println("Passenger: "+ reservation.getPassenger().getName());

            System.out.println("Flight: "+ reservation.getFlight().getFlightNumber());

            System.out.println("Seat: " + reservation.getSeatNumber());
            
            System.out.println("Status: "+ reservation.getStatus());

            System.out.println("----------------------------------");
        }
    }

    public Reservation getReservationById(int reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId() == reservationId) {

                return reservation;
            }
        }

        return null;
        
    }

    public void cancelTicket(int reservationId) {

        Reservation reservation = getReservationById(reservationId);

        if (reservation == null) {

            System.out.println("Reservation not found.");

            return;
        }

        if (reservation.getStatus().equals("CANCELLED")) {

            System.out.println("Ticket is already cancelled.");

            return;
            
        }

        reservation.cancelReservation();

        Flight flight = reservation.getFlight();

        flight.setAvailableSeats(flight.getAvailableSeats() + 1);

        System.out.println("Ticket cancelled successfully.");
    }
}