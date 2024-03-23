/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Flight;
import dto.I_Passenger;
import dto.Reservation;
import java.util.HashMap;
import util.util;
import dto.Passenger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84933
 */
public class ReservationPassenger extends HashMap<String, Reservation> implements I_Passenger {
    
    public ReservationPassenger() {
        super();
    }
    
    static Service sp = new Service();
    static FlightManangement manage;
    
    @Override
    public void passengerReservationandBooking(FlightManangement manage) {
        int getchoice;
        do {
            String departureLocation = util.getString("Enter Departure City ", "Wrong input", 1);
            
            String arrialLocation = util.getString("Enter Destination City ", "Wrong input", 1);
            
            String datego = util.getDateGo("Enter your date want to travel(yyyy/MM/dd)", 1);
            //tao list loc ra  nhung dia diem trung khop
            List<Flight> flights = new ArrayList<>();
            
            for (Flight c : manage.values()) {
                if (c.getDepartureCity().equalsIgnoreCase(departureLocation) && c.getDestinationCity().equalsIgnoreCase(arrialLocation) && c.getDepartureTime().startsWith(datego)) {
                    flights.add(c);
                }
            }
            for (Flight flight : flights) {
                System.out.println(flight.toString1());
            }
            String PassengerFlightID = util.getString("Enter Fligth ID you want to make a reservation:", "wrong", 1);
            for (Flight f : flights) {                
                if (f.getFlightNumber().equalsIgnoreCase(PassengerFlightID)) {
                    if (f.getNumSeat() > 0) {
                        String reservationID = sp.generateReservationId();
                        String passengerName = util.getString("Enter name: ", "Wrong", 1);
                        String passengerPhone = util.getRegex("Enter phone number", "^\\+?[0-9]{1,3}[-.\\s]?\\(?[0-9]{1,3}\\)?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,4}$");
                        String passengerNational = util.getRegex("Enter your nationality", "[a-zA-Z ]+$");
                        
                        Passenger newPassenger = new Passenger(passengerName, passengerNational, passengerPhone, 0);
                        
                        Reservation newReservation = new Reservation(reservationID, newPassenger, manage.get(PassengerFlightID));
                        this.put(reservationID, newReservation);
                        System.out.println("Reservation information: " + newReservation.toString1());
                    }
                }
            }
            
            getchoice = util.getInt("Do you want to back to main menu ? (yes: 1 , no: 2)", 1, 2);
            if (getchoice == 1) {
                System.out.println("----------Back to main menu!!!-------------");
                
            }
        } while (getchoice == 2);
        
    }
    //list da checkin
    ArrayList<Reservation> boardingPassAllList = new ArrayList<Reservation>();
    
    @Override
    public void passengerCheckInandSeatAllocationandAvailability(FlightManangement manage) {
        
        int getchoice = 1;
        do {
            String reservationID;
            do {
                reservationID = util.getString("Enter your reservation ID", "wrong ", 1);
                if (!sp.isDuplicatedReservationId(reservationID, this)) {
                    System.out.println("Non-available ID");
                    continue;
                }
                if (sp.isDuplicatedBoardingId(reservationID, boardingPassAllList)) {
                    System.out.println("already check in");
                    continue;
                }
            } while (!sp.isDuplicatedReservationId(reservationID, this) || sp.isDuplicatedBoardingId(reservationID, boardingPassAllList));
            
            for (Reservation value : this.values()) {
                if (value.getReservationId().equals(reservationID)) {
                    System.out.println(value.getFlight().getSeatAvailable());
                    int passengerNumSeat;
                    do {
                        passengerNumSeat = util.getInt("Enter seat you want to select", 1, value.getFlight().getTotalSeat());
                    } while (!value.getFlight().getSeatAvailable().contains(passengerNumSeat));
                    value.getPassenger().setSeatNumber(passengerNumSeat);

                    //so cho trong duoc cap nhat
                    int availableSeat = value.getFlight().getNumSeat() - 1;
                    value.getFlight().setNumSeat(availableSeat);
                    value.getFlight().getSeatAvailable().remove(Integer.valueOf(passengerNumSeat));

                    //cap nhat cho trong hashmap manage
                    for (Flight f : manage.values()) {
                        if (f.getFlightNumber().equalsIgnoreCase(value.getFlight().getFlightNumber())) {
                            f.setNumSeat(availableSeat);
                            f.getSeatAvailable().remove(passengerNumSeat);
                        }
                    }
                    System.out.println("Boarding pass: " + value.getReservationId() + "/" + value.getPassenger() + "  " + value.getFlight().toString1());
                    boardingPassAllList.add(value);
                }
                
            }
            
            getchoice = util.getInt("Do you want to back to main menu ? (yes: 1 , no: 2)", 1, 2);
            if (getchoice == 1) {
                System.out.println("----------Back to main menu!!!-------------");
                
            }
        } while (getchoice == 2);
        
    }
    
}
