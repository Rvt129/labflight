/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Flight;
import dto.I_Flight;
import java.util.ArrayList;
import java.util.HashMap;
import util.util;

/**
 *
 * @author 84933
 */
public class FlightManangement extends HashMap<String, Flight> implements I_Flight {

    public FlightManangement() {
        super();
    }

    public Service sp = new Service();

    @Override
    public void flightScheduleManagement() {

        String flightnumber;
        int getchoice;
        do {
            do {
                //check dup
                flightnumber = util.getNumber("Enter flight number(Fxxxx)", "you need to enter a Flight number", "wrong");
                if (sp.isDuplicatedCode(flightnumber, this)) {
                    System.out.println("ID cannot be duplicate. Please enter another one !");
                }
            } while (sp.isDuplicatedCode(flightnumber, this));
            String departureCity = util.getString("please enter a departure location", "wrong input", 1);
            String arriveCity;
            do {
                arriveCity = util.getString("please enter a destination ", "wrong input", 1);
            } while (arriveCity.equalsIgnoreCase(departureCity));
            String departureTime = util.getDate("Enter departure Time(yyyy/MM/dd HH:mm)", 1);
            String arrivaltime;
            do {
                arrivaltime = util.getDate("Enter arrival time(yyyy/MM/dd HH:mm)", 1);
            } while (sp.isAfter(departureTime, arrivaltime));
            int numSeat = util.getInt("Enter available seat", 0, 1000);
            int totalSeat = numSeat;
            ArrayList<Integer> seats = new ArrayList<>();
            for (int i = 1; i <= numSeat; i++) {
                seats.add(i);
            }
            Flight mangageFlight = new Flight(flightnumber, departureCity, arriveCity, departureTime, arrivaltime, seats, numSeat, totalSeat);
            this.put(flightnumber, mangageFlight);
            System.out.println("Create successfully");
            getchoice = util.getInt("Do you want to back to main menu ? (yes: 1 , no: 2)", 1, 2);
            if (getchoice == 1) {
                System.out.println("----------Back to main menu!!!-------------");

            }
        } while (getchoice == 2);
    }

}
