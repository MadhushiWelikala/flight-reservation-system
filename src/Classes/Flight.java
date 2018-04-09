/**
 * Class Name : Flight
 * @author Madhushi
 * Purpose : To maintain information about a flight. The maintained information are
 *           the flight number, departure date,departure airport,
 *           destination airport, departure time, arrival time and the flight sections.
 */

package Classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Flight {
    private String flightNumber;
    private String departureDate;
    private String departureAirport;
    private String destinationAirport;
    private String departureTime;
    private String arrivalTime;
   // private FlightSection [] sections; //size of the array depends on the number of sections in the flight (1 to 3)   //erase

    //costructor 01
    public Flight() {
    }
    
    //constructor 02
    public Flight(String flightNumber, int day, int month, int year, String departureAirport, String destinationAirport, String departureTime, String arrivalTime) {
        String airlineID = flightNumber.substring(0,2);
        String number = flightNumber.substring(2);
        this.setFlightNumber(airlineID, number);        
        setDepartureDate(day, month, year);
        this.departureAirport = departureAirport.toUpperCase();
        this.destinationAirport = destinationAirport.toUpperCase();
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
       // this.sections = sections;
    }

    
    public void setFlightNumber(String airlineID, String number) {        
        if(airlineID.matches("[a-zA-Z]+$") && airlineID.length()==2 && number.matches("[0-9 ]+$")){
            this.flightNumber = airlineID + number;
            
        }
        else{
            System.out.println("Invalid Flight Number");
        }        
        
    }
    
    public void setDepartureDate(int day, int month, int year) {             
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");     //Defines the date format needed
        Calendar calendar1 = new GregorianCalendar(year, month-1, day);   //creates a date from Calendar class   
        this.departureDate = sdf.format(calendar1.getTime());
    }    

    public void setDepartureAirport(String departureAirport) {
        
        if(departureAirport.matches("[a-zA-Z]+$") && departureAirport.length()==3){
            this.departureAirport = departureAirport.toUpperCase();
        }
        else{
            System.out.println("Invalid Airport ID");
        }
        
    }  

    public void setDestinationAirport(String destinationAirport) {
       
       if(destinationAirport.matches("[a-zA-Z]+$") && destinationAirport.length()==3){
            this.destinationAirport = destinationAirport.toUpperCase();
        }
        else{
            System.out.println("Invalid Airport ID");
        } 
        
        
    }  

    public void setDepartureTime(int hour, int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ");     //Defines the date format needed
        Calendar calendar1 = new GregorianCalendar(2016, 12, 5, hour, minute);   //creates a date from Calendar class
        this.departureTime = sdf.format(calendar1.getTime());
        
    }  

    public void setArrivalTime(int hour, int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ");     //Defines the date format needed
        Calendar calendar1 = new GregorianCalendar(2016, 12, 5, hour, minute);   //creates a date from Calendar class
        this.arrivalTime = sdf.format(calendar1.getTime());
    }  

    /*public void setSections(FlightSection[] sections) {
        this.sections = sections;
    }*/     //erase
    
    public String getFlightNumber() {
        return flightNumber;
    }
    
    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

     public String getDepartureTime() {
        return departureTime;
    }
    
      public String getArrivalTime() {
        return arrivalTime;
    }
     
     /*public FlightSection[] getSections() {
        return sections;
    }*/     
    
    @Override
    public String toString() {
        return flightNumber + "," + departureDate + "," + departureAirport + "," + destinationAirport + "," + departureTime + "," + arrivalTime ;
    }
   
    
    
}
