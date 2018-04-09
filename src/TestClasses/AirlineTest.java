package TestClasses;
import Classes.Airline;

/**
 *
 * @author Madhushi
 */
public class AirlineTest {

    public static void main(String[] args) {
        
        //test constructor 01
        Airline airline1 = new Airline();
        
        //test setters
        airline1.setAirlineID("Ul");
        airline1.setAirlineName("Sri Lankan Airlines");
        
        System.out.println(airline1);
        
        //test contructor02
        Airline airline2 = new Airline("M4", "Malasia Airlines");
        System.out.println("\n"+airline2);
        
        //test getters
        System.out.println(airline2.getAirlineID());
        System.out.println(airline2.getAirlineName());
    }
    
}
