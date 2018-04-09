package TestClasses;
import Classes.Airline;
import Classes.Flight;

/**
 *
 * @author Senarathna
 */
public class FlightTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //Test constructor 01
        Flight flight1 = new Flight();
        //System.out.println(flight1);
        
        Airline airline1 = new Airline("mH", "Malasia Airlines");
        
        //Test setters
        flight1.setFlightNumber(airline1.getAirlineID(), " 5564");
        flight1.setDepartureDate(27,11,2016);
        flight1.setDepartureAirport("cmb");
        flight1.setDestinationAirport("ccu");
        flight1.setDepartureTime(16, 35);
        flight1.setArrivalTime(19, 48);
        
        System.out.println(flight1);
        
        
        //Test constructor 02
        Flight flight2 = new Flight("UL 1123", 16, 11, 2016, "cmb", "ccu", "12:45", "14:42");
        System.out.println(flight2);
        
       //test getters
        System.out.println(flight2.getFlightNumber());
        System.out.println(flight2.getDepartureDate());
        System.out.println(flight2.getDepartureAirport());
        System.out.println(flight2.getDestinationAirport());
        System.out.println(flight2.getDepartureTime());
        System.out.println(flight2.getArrivalTime());
        
        
        
    }
    
}
