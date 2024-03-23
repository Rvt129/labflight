/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.CrewAssignment;
import dto.Flight;
import dto.I_List;
import dto.Reservation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.util;

/**
 *
 * @author 84933
 */
public class SaveandPrint extends ArrayList<Flight> implements I_List {

    static Service sp = new Service();

    @Override
    public void saveToFile(ReservationPassenger reservationPassenger, FlightManangement manangement, ManageCrewAssignment manageCrewAssignment) {
        int getchoice;
        do {
            int choice = util.getInt("Enter your ìnormation you want to save(1.Save flight/2.Save reservaton/3.Save crew manage)", 1, 3);
            if (choice == 1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("Flight.dat"));
                    String line;
                    for (Flight f : manangement.values()) {
                        line = f + "\n";
                        bw.write(line);
                    }
                    bw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (choice == 2) {
                try {
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter("Reservation.dat"));
                    String line1;
                    for (Reservation r : reservationPassenger.values()) {
                        line1 = r.toString1() + "\n";
                        bw1.write(line1);
                    }
                    bw1.close();
                } catch (Exception i) {
                    System.out.println(i);
                }
            } else if (choice == 3) {
                try {
                    BufferedWriter bw2 = new BufferedWriter(new FileWriter("CrewManage.dat"));
                    String line2;

                    for (CrewAssignment c : manageCrewAssignment.values()) {
                        line2 = c.toString1() + "\n";
                        bw2.write(line2);
                    }
                    bw2.close();
                } catch (Exception s) {
                    System.out.println(s);
                }
            }
            System.out.println("Saved Successfully!!!");
            getchoice = util.getInt("Do you want to back to main menu ? (yes: 1 , no: 2)", 1, 2);
            if (getchoice == 1) {
                System.out.println("----------Back to main menu!!!-------------");

            }
        } while (getchoice == 2);
    }

    @Override
    public void printFlightListsfromfile(FlightManangement manangement) {
        int getchoice;
        do {

            try {
                BufferedReader br = new BufferedReader(new FileReader("Flight.dat"));
                String data;
                while ((data = br.readLine()) != null) {
                    String[] flightInfo = data.split("-");
                    String flightNumber = flightInfo[0];
                    String departureCity = flightInfo[1];
                    String departureDateTime = flightInfo[2];
                    String arrivalCity = flightInfo[3];
                    String arrivalDateTime = flightInfo[4];
                    // Lấy thông tin số ghế và số ghế ch sử dụng
                    int seatAvailableCount = Integer.parseInt(flightInfo[5]);
                    int seatTotal = Integer.parseInt(flightInfo[6].split(" ")[0]);
                    // Lấy thông tin dãy các ghế ngồi
                    String seatData = data.substring(data.indexOf('[') + 1, data.indexOf(']'));
                    String[] seatArray = seatData.split(", ");
                    ArrayList<Integer> seatList = new ArrayList<>();
                    for (String seat : seatArray) {
                        seatList.add(Integer.parseInt(seat));
                    }
                    Flight flight = new Flight(flightNumber, departureCity, arrivalCity, departureDateTime, arrivalDateTime, seatList, seatAvailableCount, seatTotal);
                    if (!sp.isDuplicatedSaveId(flightNumber, this)) {
                        this.add(flight);
                    }

                    if (!sp.isDuplicatedCode(flightNumber, manangement)) {
                        manangement.put(flightNumber, flight);

                    }
                }
                br.close();

            } catch (Exception e) {
            }
            // Displaying	list	Flight information	order	by	date descending.	
            Collections.sort(this, new Comparator<Flight>() {
                @Override
                public int compare(Flight f1, Flight f2) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                    LocalDateTime check1 = null;
                    LocalDateTime check2 = null;
                    check1 = LocalDateTime.parse(f1.getDepartureTime(), formatter);
                    check2 = LocalDateTime.parse(f2.getDepartureTime(), formatter);
                    return check2.compareTo(check1);
                }
            });
            for (Flight flight : this) {
                System.out.println(flight);
            }
            getchoice = util.getInt("Do you want to back to main menu ? (yes: 1 , no: 2)", 1, 2);
            if (getchoice == 1) {
                System.out.println("----------Back to main menu!!!-------------");

            }
        } while (getchoice == 2);
    }

    public void print() {
        for (Flight flight : this) {
            System.out.println(flight);
        }
    }

}
