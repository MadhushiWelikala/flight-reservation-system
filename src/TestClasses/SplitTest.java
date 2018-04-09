package TestClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Madhushi
 */
public class SplitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] airportDetails = new String[3];
    String test = "";
    String airportID = "";
    String airportCity = "";
    String airportCountry = "";
    String[] airlineDetails = new String[2];
    String airlineID = "";
    String airlineName = "";
    String[] flightDetails = new String[6];
    String flightID = "";
    String departureDate = "";
    String departureAirport = "";
    String destinationAirport = "" ;
    String departureTime = "";
    String arivalTime ="";
    
    try(Scanner read = new Scanner(new FileInputStream("flightinfo.txt"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("splitTest.txt"))){
        
        boolean end = false;
        
        pw.println("List of Airports");
        
        while(read.hasNextLine()&& !end){
            
            String line = read.nextLine();
            
            if(line.compareTo("#") == 0){
                while(!read.hasNext("#")){
                    airportDetails = read.nextLine().split(",");
                    airportID = airportDetails[0];
                    airportCity = airportDetails[1];
                    airportCountry = airportDetails[2];
                    
                    pw.println(airportID + "\t" + airportCity + "\t" + airportCountry);
                }
                end = true;
                line = "";
            }
            
           /* if(line.compareTo("**") == 0){
                airlineDetails = read.nextLine().split(",");
                airlineID = airlineDetails[0];
                airlineName = airlineDetails[1];
                pw.println(airlineID + "\t" + airlineName);
            }
            
            if(line.compareTo("*") == 0){
                flightDetails = read.nextLine().split(",");
                flightID = flightDetails[0];
                departureDate = flightDetails[1];
                departureAirport = flightDetails[2];
                destinationAirport = flightDetails[3]; 
                departureTime = flightDetails[4];
                arivalTime = flightDetails[5];
                pw.println(flightID + "\t" + departureDate + "\t" + departureAirport + "\t" + destinationAirport + "\t" + departureTime + "\t" + arivalTime);
            }*/
            
        }
        /*boolean end = false;
        
        while(read.hasNextLine() && !end){
            String line = read.nextLine();
            
            if(line.compareTo("#") == 0){
                while(!read.hasNext("#")){                    
                    String airportInfo = read.nextLine();
                    String[] airportDet = airportInfo.split(",");
                    pw.println(airportDet[0] + "\t" + airportDet[1] + "/t" + airportDet[2]);
                }
                end = true;
                line = "";
            }
        }*/

    }
    catch(FileNotFoundException ex){
        System.out.println("File Not Found");
    }
    catch(Exception ex){
        System.out.println("Exception");
    }

    }
    
}
