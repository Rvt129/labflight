/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;


/**
 *
 * @author 84933
 */
public class Flight {

    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private String departureTime;
    private String arrivalTime;
    private ArrayList<Integer> seatAvailable;
    private int numSeat;
    private int totalSeat;

    public Flight() {
    }

    public Flight(String flightNumber, String departureCity, String destinationCity, String departureTime, String arrivalTime, ArrayList<Integer> seatAvailable, int numSeat, int totalSeat) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatAvailable = seatAvailable;
        this.numSeat = numSeat;
        this.totalSeat = totalSeat;
    }

    public int getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(int numSeat) {
        this.numSeat = numSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public ArrayList<Integer> getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(ArrayList<Integer> seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String fligtNumber) {
        this.flightNumber = fligtNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    

    public String toString1() {
        return flightNumber + "-" + departureCity + "-" + departureTime + "-" + destinationCity + "-" + arrivalTime;
    }

    @Override
    public String toString() {
        return flightNumber + "-" + departureCity + "-" + departureTime + "-" + destinationCity + "-" + arrivalTime + "-" + numSeat + "-" + totalSeat +" "+seatAvailable; //To change body of generated methods, choose Tools | Templates.
    }

}
