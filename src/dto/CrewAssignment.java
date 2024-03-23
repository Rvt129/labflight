/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author 84933
 */
public class CrewAssignment {

    private List<CrewMembers> crewMembers;
    private Flight flight;

    public CrewAssignment() {
    }

    public CrewAssignment(List<CrewMembers> crewMembers, Flight flight) {
        this.crewMembers = crewMembers;
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }


    public List<CrewMembers> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<CrewMembers> crewMembers) {
        this.crewMembers = crewMembers;
    }

   
    public String toString1() {
        return "CrewAssignment{" + "crewMembers=" + crewMembers+ "Flight ID: " +flight.getFlightNumber()+ "}";
    }

    @Override
    public String toString() {
        return "CrewAssignment{" + "crewMembers=" + crewMembers  + "Flight: "+ flight +"}";
    }

}
