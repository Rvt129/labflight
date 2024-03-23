/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageCrewAssignment;
import controller.FlightManangement;
import controller.ReservationPassenger;
import controller.SaveandPrint;
import controller.Service;
import util.util;

/**
 *
 * @author 84933
 */
public class Main {

    static FlightManangement manage = new FlightManangement();
    static ReservationPassenger reservationPassenger = new ReservationPassenger();
    static ManageCrewAssignment manageCrewAssignment = new ManageCrewAssignment();
    static SaveandPrint saveandPrint = new SaveandPrint();
    static Service s = new Service();

    public static void main(String[] args) {

        int getchoice;
        do {
            menu();
            getchoice = util.getInt("Enter function: ", 1, 8);
            switch (getchoice) {
                case 1:
                    manage.flightScheduleManagement();
                    break;
                case 2:
                    reservationPassenger.passengerReservationandBooking(manage);
                    break;
                case 3:
                    reservationPassenger.passengerCheckInandSeatAllocationandAvailability(manage);
                    break;
                case 4:
                    manageCrewAssignment.crewManagementandAdministratorAccess(manage);
                    break;
                case 5:
                    saveandPrint.saveToFile(reservationPassenger, manage, manageCrewAssignment);
                    break;
                case 6:
                    saveandPrint.printFlightListsfromfile(manage);
                    break;
                case 7:
                    s.print(reservationPassenger);
                    break;
                

            }

        } while (getchoice != 8);
        System.out.println("Existing...");
    }

    private static void menu() {
        System.out.println("=======================================================================");
        System.out.println("# 1. Flight schedule management                                       #");
        System.out.println("# 2. Passenger reservation and booking                                #");
        System.out.println("# 3. Passenger check-in and seat allocation                           #");
        System.out.println("# 4. Crew management and assignments                                  #");
        System.out.println("# 5. Save data to file                                                #");
        System.out.println("# 6. Print all lists from file flight details                         #");
        System.out.println("# 7. Print all passenger from reservation                             #");
        System.out.println("# 8. Quit                                                             #");
        System.out.println("=======================================================================");
    }
}
