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
public class CrewMembers extends Person {

    private String ID;
    private int posistion;

    public CrewMembers() {
        super();
    }

    public CrewMembers(String ID, int posistion, String name, String national, String phone) {
        super(name, national, phone);
        this.ID = ID;
        this.posistion = posistion;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPosistion() {
        return posistion;
    }

    public String getPosistionString(int posistion) {
        String result = null;
        switch (posistion) {
            //1
            case I_Posistion.POSISTION_CREW_PILOT:
                result = "Pilot";
                break;
            //2
            case I_Posistion.POSISTION_CREW_GROUNDSTAFF:
                result = "Ground Staff";
                break;
            //3
            case I_Posistion.POSISTION_CREW_FLIGHTATTENDANT:
                result = "Flight Attendant";
                break; 
        }
        return result;
    }

    public void setPosistion(int posistion) {
        this.posistion = posistion;
    }

    @Override
    public String toString() {
        return ID + "-" + getName() + "-" + getPosistionString(posistion) + "-" + getNational() + "-" + getPhone(); //To change body of generated methods, choose Tools | Templates.
    }

}
