package TestClasses;
import Classes.Airport;
/**
 *
 * @author Madhushi
 */
public class AirportTest {

    public static void main(String[] args) {
        
        //test constructor01
        Airport airport1 = new Airport();
        System.out.println(airport1);
        
        //test setters
        airport1.setAirportID("cmb");
        airport1.setCity("Colombo");
        airport1.setCountry("Sri Lanka");
        
        System.out.println(airport1);
        
        //test constructor02
        Airport airport2 = new Airport("ccu", "Kolkata", "India");
        System.out.println("\n" + airport2);
        
        //test getters
        System.out.println(airport2.getAirportID());
        System.out.println(airport2.getCity());
        System.out.println(airport2.getCountry());
        
    }
    
}
