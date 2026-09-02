package com.airline.main;

import java.util.Scanner;

import com.airline.exception.SeatNotAvailableException;
import com.airline.model.Flight;
import com.airline.model.Passenger;
import com.airline.model.Reservation;
import com.airline.service.FlightService;
import com.airline.service.PaymentService;
import com.airline.service.ReservationService;

public class AirlineApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ==========================================
        // CREATE SERVICE OBJECTS
        // ==========================================

        FlightService flightService = new FlightService();

        ReservationService reservationService = new ReservationService();

        PaymentService paymentService = new PaymentService();

        int choice;

        // ==========================================
        // MAIN MENU
        // ==========================================

        do {

            System.out.println("======================================");
            System.out.println("     AIRLINE RESERVATION SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Flight");
            System.out.println("2. View All Flights");
            System.out.println("3. Search Flight");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Reservations");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Exit");

            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            // ==========================================
            // CASE 1: ADD FLIGHT
            // ==========================================

            case 1:

                System.out.println();
                System.out.println("========== ADD FLIGHT ==========");

                System.out.print("Enter Flight ID: ");
                int flightId = sc.nextInt();

                System.out.print("Enter Flight Number: ");
                String flightNumber = sc.next();

                System.out.print("Enter Airline Name: ");
                String airlineName = sc.next();

                System.out.print("Enter Source: ");
                String source = sc.next();

                System.out.print("Enter Destination: ");
                String destination = sc.next();

                System.out.print("Enter Date: ");
                String date = sc.next();
                
                System.out.print("Enter Time: ");
                String time = sc.next();

                System.out.print("Enter Total Seats: ");
                int totalSeats = sc.nextInt();
                
                System.out.print("Enter Available Seats: ");
                int availableSeats = sc.nextInt();

                System.out.print("Enter Ticket Price: ");
                double price = sc.nextDouble();

                Flight flight = new Flight(flightId,flightNumber,airlineName,source,destination,date,time,totalSeats,availableSeats,price);

                // Connect Main → FlightService

                flightService.addFlight(flight);

                break;


            // ==========================================
            // CASE 2: VIEW ALL FLIGHTS
            // ==========================================

            case 2:

                System.out.println();
                System.out.println("========== ALL FLIGHTS ==========");

                // Connect Main → FlightService

                flightService.displayFlights();

                break;


            // ==========================================
            // CASE 3: SEARCH FLIGHT
            // ==========================================

            case 3:

                System.out.println();
                System.out.println("========== SEARCH FLIGHT ==========");

                System.out.print("Enter Source: ");
                String searchSource = sc.next();

                System.out.print("Enter Destination: ");
                String searchDestination = sc.next();

                // Connect Main → FlightService

                flightService.searchFlight(searchSource,searchDestination);

                break;


            // ==========================================
            // CASE 4: BOOK TICKET
            // ==========================================

            case 4:

                System.out.println();
                System.out.println("========== BOOK TICKET ==========");

                // --------------------------------------
                // STEP 1: GET FLIGHT ID
                // --------------------------------------

                System.out.print("Enter Flight ID: ");

                int selectedFlightId = sc.nextInt();

                // Get flight from FlightService

                Flight selectedFlight = flightService.getFlightById(selectedFlightId);

                // --------------------------------------
                // CHECK FLIGHT
                // --------------------------------------

                if (selectedFlight == null) {

                    System.out.println("Flight not found.");

                    break;
                }

                System.out.println();
                System.out.println("Selected Flight:");
                System.out.println(selectedFlight);

                // --------------------------------------
                // STEP 2: PASSENGER DETAILS
                // --------------------------------------

                System.out.print("Enter Passenger ID: ");
                int passengerId = sc.nextInt();

                System.out.print("Enter Username: ");
                String username = sc.next();

                System.out.print("Enter Password: ");
                String password = sc.next();

                System.out.print("Enter Passenger Name: ");
                String passengerName = sc.next();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Gender: ");
                String gender = sc.next();

                System.out.print("Enter Phone: ");
                String phone = sc.next();

                // --------------------------------------
                // CREATE PASSENGER OBJECT
                // --------------------------------------

                Passenger passenger = new Passenger(passengerId,username,password,passengerName,age,gender,phone);

                // --------------------------------------
                // STEP 3: SEAT NUMBER
                // --------------------------------------

                System.out.print("Enter Seat Number: ");
                int seatNumber = sc.nextInt();

                Reservation reservation;

                // --------------------------------------
                // STEP 4: BOOK TICKET
                // --------------------------------------

                try {

                    reservation = reservationService.bookTicket(passenger,selectedFlight,seatNumber);

                } catch (SeatNotAvailableException e) {

                    System.out.println("Booking failed: " + e.getMessage());

                    break;
                }

                // --------------------------------------
                // STEP 5: PAYMENT
                // --------------------------------------

                System.out.println();
                System.out.println("========== PAYMENT ==========");

                System.out.println("1. UPI");
                System.out.println("2. Card");

                System.out.print("Select Payment Method: ");

                int paymentChoice = sc.nextInt();

                boolean paymentSuccess = paymentService.processPayment(selectedFlight.getPrice(),paymentChoice);

                // --------------------------------------
                // STEP 6: GENERATE TICKET
                // --------------------------------------

                if (paymentSuccess) {

                    System.out.println();
                    System.out.println("Payment successful.");

                    System.out.println("Booking completed.");

                    System.out.println("Reservation ID: "+ reservation.getReservationId());

                } else {

                    System.out.println("Payment failed.");
                }

                break;


            // ==========================================
            // CASE 5: VIEW RESERVATIONS
            // ==========================================

            case 5:

                System.out.println();
                System.out.println("========== RESERVATIONS ==========");

                // Connect Main → ReservationService

                reservationService.displayReservations();

                break;


            // ==========================================
            // CASE 6: CANCEL TICKET
            // ==========================================

            case 6:

                System.out.println();
                System.out.println("========== CANCEL TICKET ==========");

                System.out.print("Enter Reservation ID: ");

                int reservationId =sc.nextInt();

                // Connect Main → ReservationService

                reservationService.cancelTicket(reservationId);

                break;


            // ==========================================
            // CASE 7: EXIT
            // ==========================================

            case 7:

                System.out.println();
                System.out.println("Thank you for using "+ "Airline Reservation System!");

                break;


            // ==========================================
            // DEFAULT
            // ==========================================

            default:

                System.out.println("Invalid choice. "+ "Please enter 1 to 7.");
            }

        } while (choice != 7);

        // ==========================================
        // CLOSE SCANNER
        // ==========================================

        sc.close();
    }
}