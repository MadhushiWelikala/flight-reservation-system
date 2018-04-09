package Classes;

import GUI.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Madhushi
 */
public class SystemManager {
   
    private String inputFile;       //the file contains all details    
    private Airport[] airport;      //stores details of all airports
    private Airline[] airlines;     //store details of all airlines
    private Flight[] flights;       //stores details of all flights belongs to all airlines    
    private Seat[][] seats;          //stores details of seats belongs to all flights;
    private Reservation[] reservations = new Reservation[448];
    public static int reservationNumber = -1;
    

    public SystemManager(String inputFile){
        
        this.inputFile = inputFile;
        
        this.readAirportDetails();
        this.readAirLineDetails();
        this.readFlightDetails();
        
        this.setFlightSeatDetails();
        
        this.loadReservations();
    }

    public void setAirport(Airport[] airport) {
        this.airport = airport;
    }

    public void setAirlines(Airline[] airline) {
        this.airlines = airline;
    }

    public void setFlights(Flight[] flight) {
        this.flights = flight;
    }

    public void setSeat(Seat[][] seat) {
        this.seats = seat;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }
    
    

    public Airport[] getAirport() {
        return airport;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public Seat[][] getSeat() {
        return seats;
    }

    public String getInputFile() {
        return inputFile;
    }
    
     //This Method reads all airportDetails from the relevant inputFile and writes them in an array
    public final void readAirportDetails(){
        Airport[] airport = new Airport[7];
        String[] airportDetails = new String[3];
        String airportID = "";
        String airportCity = "";
        String airportCountry = "";
        int i = 0;
        
        try(Scanner read = new Scanner(new FileInputStream(this.inputFile));
            PrintWriter pw = new PrintWriter(new FileOutputStream("airport.txt"))){
        
            boolean end = false;
            
            while(read.hasNextLine()&& !end){

                String line = read.nextLine();

                if(line.compareTo("#") == 0){
                    while(!read.hasNext("#")){                        
                        airportDetails = read.nextLine().split(",");
                        airportID = airportDetails[0];
                        airportCity = airportDetails[1];
                        airportCountry = airportDetails[2];

                        airport[i] = new Airport(airportID, airportCity, airportCountry);
                        
                        pw.println(airport[i]);
                         i++; 
                    }
                    end = true; 
                    line = "";
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found");
        }
        catch(Exception ex){
            System.out.println("Exception");
        }
        
        this.setAirport(airport);
        
    }
    
    //This Method reads all airlineDetails from the relevant inputFile and writes them in an array
    public final void readAirLineDetails(){
        
        Airline[] airline = new Airline[5];
        String[] airlineDetails = new String[2];
        String airlineID = "";
        String airlineName = "";
        int i=0;
        
        try(Scanner read = new Scanner(new FileInputStream(this.inputFile));
            PrintWriter pw = new PrintWriter(new FileOutputStream("airline.txt"))){
        
            boolean end = false;
            
            while(read.hasNextLine()&& !end){

                String line = read.nextLine();

                if(line.compareTo("**") == 0){
                    airlineDetails = read.nextLine().split(",");
                    airlineID = airlineDetails[0];
                    airlineName = airlineDetails[1];

                    airline[i] = new Airline(airlineID, airlineName);                    
                     pw.println(airline[i]);
                     i++;
                    
                }                
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        this.setAirlines(airline);
    }
    
        //This Method reads all flightDetails from the relevant inputFile and writes them in an array
    public final void readFlightDetails(){
        
        Flight[] flight = new Flight[40];
        String[] flightDetails = new String[6];
        String flightID = "";
        String[] departureDate = new String[3];
        String departureAirport = "";
        String destinationAirport = "" ;
        String departureTime = "";
        String arrivalTime ="";
        int i = 0;
        
        try(Scanner read = new Scanner(new FileInputStream(this.inputFile));
            PrintWriter pw = new PrintWriter(new FileOutputStream("flight.txt"))){
        
            boolean end = false;
            
            while(read.hasNextLine()&& !end){

                String line = read.nextLine();

                if(line.compareTo("*") == 0){                    
                    flightDetails = read.nextLine().split(",");
                     flightID = flightDetails[0];
                     departureDate = flightDetails[1].split("-");
                     int deptDay = Integer.parseInt(departureDate[0]);
                     int deptMonth = Integer.parseInt(departureDate[1]);
                     int deptYear = Integer.parseInt(departureDate[2]);
                     departureAirport = flightDetails[2];
                     destinationAirport = flightDetails[3]; 
                     departureTime = flightDetails[4];
                     arrivalTime = flightDetails[5];

                     flight[i] = new Flight(flightID, deptDay, deptMonth, deptYear, departureAirport, destinationAirport, departureTime, arrivalTime);
                     
                     
                     pw.println(flight[i]);
                     i++;
                     
                    // pw.println(flightID + "\t" + Arrays.toString(departureDate) + "\t" + departureAirport + "\t" + destinationAirport + "\t" + departureTime + "\t" + arrivalTime);
                    
                }           
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found");
        }
        catch(Exception ex){
            System.out.println("Exception");
        }
        
        this.setFlights(flight);
    }
    
     //This Method reads all seatDetails of a flight and assign relevant flightClass from the relevant inputFile and writes them in an array
    public Seat[] readFlightSeatDetails(String flightID){          
        Seat[] seat = new Seat[448];
        String[] ftDetails = new String[6];        
        String ftID = "";
        int numberOfRows = 0;
        String[] rowsOfTheClass = new String[numberOfRows]; 
        String columnChar = "";
        String rowNumber = "";
        String seatID = "";
        boolean seatAvailability = false;       //false if available
        int seatArrayIndex = -1;
        
        try(Scanner read = new Scanner(new FileInputStream(inputFile));
            PrintWriter pw = new PrintWriter(new FileOutputStream("seat.txt"),true)){
             
             while(read.hasNextLine()){     
                   if(read.nextLine().compareTo("*") == 0){
                       ftDetails = read.nextLine().split(",");
                        ftID = ftDetails[0]; 

                        if(ftID.compareTo(flightID) == 0){ 
                            for(int className=0; className<3; className++){
                                switch(className){              //splits classes into rows and store in the array
                                    case 0:
                                        numberOfRows = 4;
                                        rowsOfTheClass = read.nextLine().split("@"); 
                                        for(int i=0; i<rowsOfTheClass.length; i++){                                            
                                            rowNumber = Integer.toString(i+1);
                                            for(int j=0; j<4; j++){
                                                switch(j){
                                                case 0:
                                                     columnChar = "A";
                                                    break;
                                                case 1:
                                                    columnChar = "B";
                                                    break;
                                                case 2:
                                                    columnChar = "G";
                                                    break;
                                                case 3:
                                                    columnChar = "H"; 
                                                    break;
                                                }                                            
                                                seatID = columnChar + rowNumber;
                                                if(rowsOfTheClass[i].charAt(j)== 'f'){
                                                    seatAvailability = false;
                                                }
                                                else{
                                                    seatAvailability = true;
                                                }
                                                seatArrayIndex+=1;
                                                seat[seatArrayIndex] = new Seat(seatID, seatAvailability);
                                                
                                                pw.println(seatArrayIndex + "\t" + seatID + "\t" + seatAvailability);
                                            }                                            
                                            
                                        }
                                        
                                        break;
                                    case 1:
                                        numberOfRows = 6;
                                        rowsOfTheClass = read.nextLine().split("@"); 
                                        for(int i=0; i<rowsOfTheClass.length; i++){                                            
                                            rowNumber = Integer.toString(i+5);                                            
                                            for(int j=0; j<6; j++){
                                                switch(j){
                                                    case 0:
                                                        columnChar = "A";
                                                        break;
                                                    case 1:
                                                        columnChar = "B";
                                                        break;
                                                    case 2:
                                                        columnChar = "C";
                                                        break;
                                                    case 3:
                                                        columnChar = "F";
                                                        break;
                                                    case 4:
                                                        columnChar = "G";
                                                        break;
                                                    case 5:
                                                        columnChar = "H";
                                                        break;
                                                }                                            
                                                seatID = columnChar + rowNumber;
                                                if(rowsOfTheClass[i].charAt(j)== 'f'){
                                                    seatAvailability = false;
                                                }
                                                else{
                                                    seatAvailability = true;
                                                }
                                                seatArrayIndex+=1;
                                                seat[seatArrayIndex] = new Seat(seatID, seatAvailability);
                                                
                                                pw.println(seatArrayIndex + "\t" + seatID + "\t" + seatAvailability);
                                            }
                                        }
                                       
                                        break;
                                    case 2:
                                        numberOfRows = 48;
                                        rowsOfTheClass = read.nextLine().split("@"); 
                                        for(int i=0; i<rowsOfTheClass.length; i++){                                            
                                            rowNumber = Integer.toString(i+13);  
                                            for(int j=0; j<8; j++){
                                                switch(j){
                                                    case 0:
                                                        columnChar = "A";
                                                        break;
                                                    case 1:
                                                        columnChar = "B";
                                                        break;
                                                    case 2:
                                                        columnChar = "C";
                                                        break;
                                                    case 3:
                                                        columnChar = "D";
                                                        break;
                                                    case 4:
                                                        columnChar = "E";
                                                        break;
                                                    case 5:
                                                        columnChar = "F";
                                                        break;
                                                    case 6:
                                                        columnChar = "G";
                                                        break;
                                                    case 7:
                                                        columnChar = "H";
                                                        break;
                                                }                                            
                                                seatID = columnChar + rowNumber;
                                                if(rowsOfTheClass[i].charAt(j)== 'f'){
                                                    seatAvailability = false;
                                                }
                                                else{
                                                    seatAvailability = true;
                                                }
                                                seatArrayIndex+=1;
                                                seat[seatArrayIndex] = new Seat(seatID, seatAvailability);
                                                
                                                pw.println(seatArrayIndex + "\t" + seatID + "\t" + seatAvailability);
                                            }
                                            
                                        }
                                        
                                        break;
                                }

                                                              
                            }
                        }
                   }      
                                  
            }               
        }
         catch(FileNotFoundException ex){
             System.out.println("File Not Found");
         }
         catch(Exception ex){
             System.out.println("Exception");
         }
        
        return seat;
    }
    //this takes seat details of all flights into an array
    public void setFlightSeatDetails(){
        Seat[][] flightSeats = new Seat[40][448];
        for(int m=0; m<flights.length; m++){
            String flightID = this.flights[m].getFlightNumber();
            flightSeats[m] = this.readFlightSeatDetails(flightID);
        }
        
        this.setSeat(flightSeats);
    }
    
    //this seatches for the flight availability for a particular flight
    public String searchFlight(int day, int month, int year, String departureAirport, String destinationAirport, String airlineID){

//      boolean end = false;
//      int i=0;
      String alineID = "";      
      Flight flight1 = new Flight();
      flight1.setDepartureDate(day, month, year);
      int availableSeatCount = 0;
      String str = "";
      
      for(int i=0; i<flights.length; i++){
          alineID = flights[i].getFlightNumber().substring(0,2);
          
          if(alineID.compareTo(airlineID) == 0){
              if(flights[i].getDepartureAirport().compareTo(departureAirport) == 0 && flights[i].getDestinationAirport().compareTo(destinationAirport) == 0){
                  if(flights[i].getDepartureDate().compareTo(flight1.getDepartureDate()) == 0){
                     Seat[][] seat = this.getSeat();
                      for(int j=0; j<seat.length; j++){
                          if(seat[i][j].isStatus()==false){
                              availableSeatCount+=1;
                          }
                          
                      }
                      str = flights[i].getFlightNumber() + "@" + flights[i].getDepartureTime() + "@" + flights[i].getArrivalTime() + "@" + availableSeatCount;
                     // System.out.println(str);
//                      end = true;
                  }
              }
          }
      
      }
      return str;
    }
    //gives the number of seats available to reserve in a particular flight
    public String searchFlightSeatAvailability(String flightID){
        Seat[][] seat = this.getSeat();
        String seatID = "";
        boolean seatAvailability = false;
        int availableFClass = 0;
        int availableBClass = 0;
        int availableEClass = 0;
        String str = "";
        
        for(int j=0; j<flights.length; j++){
            if(flights[j].getFlightNumber().compareTo(flightID) == 0){
                for(int i=0; i<448; i++){
                    if(seat[j][i].isStatus()==false){
                        if(i<16){
                            availableFClass+=1;
                        }
                        else if(i<64){
                            availableBClass+=1;
                        }
                        else{
                            availableEClass+=1;
                        }
                    }
                }
            }
        }
        
       str = availableFClass + "@" + availableBClass + "@" + availableEClass;
       return str; 
    }
    //gives seat details of a particular flight
    public Seat[] getSeatDetails(String flightID){
        Seat[][] seat = this.getSeat();
        Seat[] seatDetails = new Seat[448];
        String seatID = "";
        boolean seatStatus = false;
        
        for(int j=0; j<flights.length; j++){
            if(flights[j].getFlightNumber().compareTo(flightID) == 0){
                for(int i=0; i<448; i++){
                    seatID = seat[j][i].getSeatID();
                    seatStatus = seat[j][i].isStatus();
                    
                    seatDetails[i] = new Seat(seatID, seatStatus);
                }
            }
        }
        
       return seatDetails;
    }
     //gets the departure date of a particular flight 
    public String getDeparturedate(String flightID){
        String deptDate = ""; 
        
        for(int j=0; j<flights.length; j++){
            if(flights[j].getFlightNumber().compareTo(flightID) == 0){
               deptDate = flights[j].getDepartureDate();
            }
        }
        return deptDate;
    }
    
     //returns a reservation type object for a particular reservation
     public Reservation makeReservation(int number, Passenger[] passengers,String flightID,String deptDate,Seat[] seat)
     {         
         reservationNumber++;
         
         Reservation reserve = new Reservation(reservationNumber,number, passengers, flightID, deptDate,seat);
         
         reservations[reservationNumber]=reserve;
         
         return reserve;
     }
     //save reservation details to file from array
     public void saveReservations()
     {
         try(PrintWriter pw = new PrintWriter(new FileOutputStream("reservations.txt"))){
        
           for(int q=0; q<=reservationNumber; q++){
               pw.println("#");
               pw.println(reservations[q].toString());
               pw.print("##");
           }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     }
     
    //load reservation details from file to array
         //set the reservationNumber to the reservationID of the last entry of the reservation file
     public void loadReservations(){
         try(Scanner read = new Scanner(new FileInputStream("reservations.txt"))){             
            //PrintWriter pw = new PrintWriter(new FileOutputStream("airport.txt"))){
            String[] reserveDetails = new String[6];
            boolean end = false;
            int resNumber;            
            int numberOfPassengers = 0;
            Passenger[] passengers = new Passenger[numberOfPassengers];
            String flightID = "";
            String departureDate = "";
            String[] reservedseatId;
            String[] passengerDetails = new String[numberOfPassengers];
            String[] singlePassengerDetails = new String[5];
            Seat[] reservedSeats = new Seat[numberOfPassengers];
            
            while(read.hasNextLine()&& !end){

                String line = read.nextLine();

                if(line.compareTo("#") == 0){
                    while(!read.hasNext("##")){                        
                        for(int q=0; q<=reservationNumber; q++){
                            reserveDetails=read.nextLine().split("*");
                            resNumber = Integer.parseInt(reserveDetails[0]);
                            numberOfPassengers = Integer.parseInt(reserveDetails[1]);
                            
                             passengerDetails = reserveDetails[2].substring(1, reserveDetails[2].length()).split(", ");        //check
                            for(int d=0; d<passengerDetails.length; d++){
                                singlePassengerDetails = passengerDetails[d].split("@");
                                Name name = new Name(singlePassengerDetails[0], singlePassengerDetails[1]);
                                Address address = new Address(singlePassengerDetails[2], singlePassengerDetails[3]);
                                passengers[d] = new Passenger(name, address, singlePassengerDetails[4]);
                            }
                            flightID = reserveDetails[3];
                            departureDate = reserveDetails[4];                            
                             reservedseatId = reserveDetails[5].substring(1, reserveDetails[5].length()).split(", ");      //check
                            for(int x=0; x<reservedseatId.length; x++){
                                reservedSeats[x] = new Seat(reservedseatId[x],true);  
                            }
                            
                            Reservation reserve = new Reservation(reservationNumber, numberOfPassengers, passengers, flightID, departureDate,reservedSeats);
                        }
                    }
                    end = true; 
                    line = "";
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
         
         this.setReservations(reservations);
     }
     
   
         //delete reservation from array and adjust the array
        public void cancelReservation(int resNumber){

            for(int i = 0 ; i < reservationNumber+1 ; i++){
                int resID = reservations[i].getReservationNumber();
                if(resID == resNumber){
                    for(int j = i ; j < reservationNumber ; j++){
                        reservations[j] = reservations[j+1];
                    }
                }

            }

        }
     
     //save all flight info changes to flightinfo.txt
     
         public void saveFlightInfo(){
         
            String alineID = "";
                boolean seatStatus = true;
                char status = 't' ;
                char columnchar ;
                int rowNumber = 0;
                int seatCount = 0;
                char[] seatRowOne = new char[16];
                char[] seatRowTwo = new char[48];
                char[] seatRowThree = new char[384];

                try(PrintWriter pw = new PrintWriter(new FileOutputStream("finalFlightInfo.txt"))){

                    pw.println("#");
                                for(int airportNumber=0; airportNumber<airport.length; airportNumber++){
                                        pw.println(airport[airportNumber].toString());
                                }
                                 pw.println("#");

                                for(int airlineNumber=0; airlineNumber<airlines.length; airlineNumber++){
                                        pw.println("**");
                                        pw.println(airlines[airlineNumber].toString());
                                        for(int flightNumber=0; flightNumber<flights.length; flightNumber++){
                                                alineID = flights[flightNumber].getFlightNumber().split(" ")[0];	
                                                if(airlines[airlineNumber].getAirlineID().compareTo(alineID)==0){
                                                        pw.println("*");
                                                        pw.println(flights[flightNumber].toString());

                                                        for(int seatNumber=0; seatNumber<448; seatNumber++){
                                                                seatStatus = seats[flightNumber][seatNumber].isStatus();
                                                                if(seatStatus == false){
                                                                        status = 'f';
                                                                }
                                                                else if(seatStatus == true){
                                                                        status = 't';
                                                                }

                                                                columnchar = seats[flightNumber][seatNumber].getSeatID().charAt(0);
                                                                rowNumber = Integer.parseInt(seats[flightNumber][seatNumber].getSeatID().substring(1));

                                                                if(rowNumber <5){
                                                                        //seatCount = 16;
                                                                        seatRowOne[seatNumber] = status;
                                                                }
                                                                else if(rowNumber<13){
                                                                        //seatCount = 48;
                                                                        seatRowTwo[seatNumber-16] = status;
                                                                }
                                                                else{
                                                                        //seatCount = 384;
                                                                        seatRowThree[seatNumber-64] = status;
                                                                }
                                                        }
                                                        for(int s=0; s<4; s++){
                                                                for(int u=0; u<4; u++){
                                                                        pw.print(seatRowOne[seatCount]);
                                                                        seatCount+=1;
                                                                }
                                                                pw.print("@");
                                                        }
                                                        seatCount=0;
                                                        pw.println();
                                                        for(int s=0; s<8; s++){
                                                                for(int u=0; u<6; u++){
                                                                        pw.print(seatRowTwo[seatCount]);
                                                                        seatCount+=1;
                                                                }
                                                                pw.print("@");
                                                        }
                                                        seatCount=0;
                                                        pw.println();
                                                        for(int s=0; s<48; s++){
                                                                for(int u=0; u<8; u++){
                                                                        pw.print(seatRowThree[seatCount]);
                                                                        seatCount+=1;
                                                                }
                                                                pw.print("@");
                                                        }
                                                        pw.println();
//
                                                }					

                                        }

                                }

                }
                catch(FileNotFoundException ex){
                    System.out.println(ex.getMessage());
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
	}
         
        public Passenger[]  viewPassengerList(String flightID){
            String ftID = "";            
            Passenger[] passengers = new Passenger[448];
            int passengerCount = 0;
            for(int i=0; i<=reservationNumber; i++){
                ftID = reservations[i].getFlightNumber();
                if(ftID.compareTo(flightID)==0){
                    passengers = reservations[i].getPassengersArray();
                }
            }
            return passengers;
        
        }
         
         
    }
     
    
   

