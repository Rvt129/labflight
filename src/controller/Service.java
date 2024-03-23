/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author 84933
 */
import dto.CrewAssignment;
import dto.CrewMembers;
import dto.Flight;
import dto.Reservation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 84933
 */
public class Service {

    public boolean isDuplicatedCode(String flightnumber, FlightManangement manage) {
        for (String c : manage.keySet()) {
            if (c.equalsIgnoreCase(flightnumber)) {
                return true;
            }
        }
        return false;
    }

    boolean isAfter(String departureTime, String arrivaltime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime check = LocalDateTime.parse(departureTime, formatter);
        LocalDateTime check2 = LocalDateTime.parse(arrivaltime, formatter);
        if (check.isAfter(check2)) {
            return true;
        }
        return false;
    }

    public String generateReservationId() {
        int length = 7;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public boolean isDuplicatedReservationId(String ID, ReservationPassenger reservation) {
        for (String c : reservation.keySet()) {
            if (c.equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicatedSaveId(String ID, SaveandPrint print) {
        for (Flight c : print) {
            if (c.getFlightNumber().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicatedReservationFlightId(String ID, ReservationPassenger reservation) {
        for (Reservation c : reservation.values()) {
            if (c.getFlight().getFlightNumber().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicatedCrewFlightId(String ID, ManageCrewAssignment manageCrewAssignment) {
        for (CrewAssignment c : manageCrewAssignment.values()) {
            if (c.getFlight().getFlightNumber().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicatedPilotId(String id, ArrayList<CrewMembers> list) {
        for (CrewMembers object : list) {
            if (object.getID().equalsIgnoreCase(id) && object.getPosistion() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicatedStaffId(String id, ArrayList<CrewMembers> list) {
        for (CrewMembers object : list) {
            if (object.getID().equalsIgnoreCase(id) && object.getPosistion() == 2) {
                return true;
            }
        }
        return false;
    }
    public boolean isDuplicatedFilghtAttendantId(String id, ArrayList<CrewMembers> list) {
        for (CrewMembers object : list) {
            if (object.getID().equalsIgnoreCase(id) && object.getPosistion() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicatedBoardingId(String id, ArrayList<Reservation> list) {
        for (Reservation object : list) {
            if (object.getReservationId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public void print(ReservationPassenger reservation){
        for (Reservation object : reservation.values()) {
            System.out.println(object.getPassenger());
        }
    }
    
}
