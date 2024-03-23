/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import controller.ManageCrewAssignment;
import controller.FlightManangement;
import controller.ReservationPassenger;

/**
 *
 * @author 84933
 */
public interface I_List {

    void saveToFile(ReservationPassenger reservationPassenger, FlightManangement manangement, ManageCrewAssignment manageCrewAssignment);

    void printFlightListsfromfile(FlightManangement manangement);
}
