/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author 84933
 */
public class Reservation {

    private String reservationId;
    private Passenger passenger;
    private Flight flight;

    public Reservation(String reservationId, Passenger passenger, Flight flight) {
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Reservation() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String toString1() {
        return reservationId + "/" + passenger + "    /     " + flight.toString1();
    }

    @Override
    public String toString() {
        return reservationId + "/" + passenger + "    /     " + flight; //To change body of generated methods, choose Tools | Templates.
    }

}
