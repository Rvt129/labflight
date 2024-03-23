/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.CrewMembers;

import dto.I_Crew;
import dto.CrewAssignment;
import dto.Flight;
import java.util.ArrayList;
import java.util.HashMap;
import util.util;

/**
 *
 * @author 84933
 */
public class ManageCrewAssignment extends HashMap<String, CrewAssignment> implements I_Crew {

    static Service sp = new Service();

    @Override
    public void crewManagementandAdministratorAccess(FlightManangement flightManangement) {
        int getchoice = 0;
        do {
            String flightID;
            do {
                flightID = util.getString("Enter flight number you want to manage Crew members: ", "wrong", 1);
                if (!sp.isDuplicatedCode(flightID, flightManangement)) {
                    System.out.println("Non-availalble flight");
                    continue;
                }
                if (sp.isDuplicatedCrewFlightId(flightID, this)) {
                    System.out.println("Already in");
                    break;
                }
            } while (!sp.isDuplicatedCode(flightID, flightManangement) || sp.isDuplicatedCrewFlightId(flightID, this));
            Flight flight = new Flight();
            for (Flight f : flightManangement.values()) {
                if (f.getFlightNumber().equalsIgnoreCase(flightID)) {
                    flight = new Flight(f.getFlightNumber(), f.getDepartureCity(), f.getDestinationCity(), f.getDepartureTime(), f.getArrivalTime(), f.getSeatAvailable(), f.getNumSeat(), f.getTotalSeat());
                }
            }

            //pilot information
            ArrayList<CrewMembers> crewMembers = new ArrayList<>();
            int choice;
            do {
                String pilotID;
                do {
                    pilotID = util.getString("Enter pilotID", "wrong", 1);
                    if (sp.isDuplicatedPilotId(pilotID, crewMembers)) {
                        System.out.println("Already this pilot in list");
                    }
                } while (sp.isDuplicatedPilotId(pilotID, crewMembers));
                String pilotName = util.getString("Enter pilot name", "wrong", 1);
                String pilotNationality = util.getRegex("Enter pilot nationality", "[a-zA-Z ]+$");
                String pilotPhone = util.getRegex("Enter phone number", "^\\+?[0-9]{1,3}[-.\\s]?\\(?[0-9]{1,3}\\)?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,4}$");
                CrewMembers newPilot = new CrewMembers(pilotID, 1, pilotName, pilotNationality, pilotPhone);
                crewMembers.add(newPilot);
                choice = util.getInt("Do you want to add more pilot ? (yes: 1 , no: 2)", 1, 2);
            } while (choice == 1);
            //staff information
            int choice1;
            do {
                String staffId;
                do {
                    staffId = util.getString("Enter staffID", "wrong", 1);
                    if (sp.isDuplicatedStaffId(staffId, crewMembers)) {
                        System.out.println("Already this staff in list");
                    }
                } while (sp.isDuplicatedStaffId(staffId, crewMembers));
                String staffName = util.getString("Enter staff name", "wrong", 1);
                String staffNationality = util.getRegex("Enter staff nationality", "[a-zA-Z ]+$");
                String staffPhone = util.getRegex("Enter phone number", "^\\+?[0-9]{1,3}[-.\\s]?\\(?[0-9]{1,3}\\)?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,4}$");
                CrewMembers newStaff = new CrewMembers(staffId, 2, staffName, staffNationality, staffPhone);
                crewMembers.add(newStaff);
                choice1 = util.getInt("Do you want to add more staff ? (yes: 1 , no: 2)", 1, 2);
            } while (choice1 == 1);
            //flightAttendant info
            int choice2;
            do {
                String flightAttendantId;
                do {
                    flightAttendantId = util.getString("Enter Filght AttendantID", "wrong", 1);
                    if (sp.isDuplicatedFilghtAttendantId(flightAttendantId, crewMembers)) {
                        System.out.println("Already this Filght Attendant in list");
                    }
                } while (sp.isDuplicatedFilghtAttendantId(flightAttendantId, crewMembers));
                String flightAttendantName = util.getString("Enter Filght Attendant name", "wrong", 1);
                String flightAttendantNationality = util.getRegex("Enter Filght Attendant nationality", "[a-zA-Z ]+$");
                String flightAttendantPhone = util.getRegex("Enter phone number", "^\\+?[0-9]{1,3}[-.\\s]?\\(?[0-9]{1,3}\\)?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,4}$");
                CrewMembers newFlightAttendant = new CrewMembers(flightAttendantId, 3, flightAttendantName, flightAttendantNationality, flightAttendantPhone);
                crewMembers.add(newFlightAttendant);
                System.out.println("Successfully!!!");
                choice2 = util.getInt("Do you want to add more Flight Attendant ? (yes: 1 , no: 2)", 1, 2);
            } while (choice2 == 1);

            CrewAssignment list = new CrewAssignment(crewMembers, flight);
            this.put(flightID, list);

            getchoice = util.getInt("Do you want to back to main menu ? (yes: 1 , no: 2)", 1, 2);
            if (getchoice == 1) {
                System.out.println("----------Back to main menu!!!-------------");
            }

        } while (getchoice == 2);
    }

}
