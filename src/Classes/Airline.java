/**
 * Class Name : Airline
 * @author Madhushi
 * Purpose : To maintain information of an Airline. The maintained 
 *           information are, the airline ID and the name of the airline.
 */

package Classes;

import java.io.*;
import java.util.Scanner;


public class Airline {
    private String airlineID;   //two-lettered ID
    private String airlineName;    //name of the airline

    //constructor 01
    public Airline() {
        this.airlineID = "";
        this.airlineName = "";
    }

    //constructor 02
    public Airline(String airlineID, String name) {
        this.setAirlineID(airlineID);
        this.setAirlineName(name);
        
    }

    public void setAirlineID(String airlineID) {
        
        if(airlineID.matches("[a-zA-Z]+$") && airlineID.length()==2){
            this.airlineID = airlineID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airline ID");
        }
        
    }

    public void setAirlineName(String airlineName) {
     
        if (airlineName.matches("[a-zA-Z ]+$")) {
            this.airlineName = airlineName;
        }
        else{
            System.out.println("Invalid Airline Name");
        }
        
    }

    public String getAirlineID() {
        return airlineID; //returns airlineID in capitals
    }

    public String getAirlineName() {
        return airlineName;
    }
    
    @Override
    public String toString() {
        return this.getAirlineID() + "," + this.getAirlineName();
    }
    
    
    
    
    
}
