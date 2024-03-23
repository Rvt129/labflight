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
public class Passenger extends Person {

    private int seatNumber;

    public Passenger() {
        super();
    }

    public Passenger(String name, String national, String phone, int seatNumber) {
        super(name, national, phone);
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return getName() + "/" + getPhone() + "/" + getNational() + "--" + getSeatNumber(); //To change body of generated methods, choose Tools | Templates.
    }

}
