package TestClasses;

import Classes.FlightSection;
import Classes.SeatClass;

/**
 *
 * @author Madhushi
 */
public class FlightSectionTest {

    public static void main(String[] args) {
        
       //Test constructor1
       FlightSection flightSection1 = new FlightSection();
        //System.out.println(flightSection1);
        
        //Test Setters
        flightSection1.setSeatClass(SeatClass.ECONOMY);
        System.out.println(flightSection1);
        
        //Test constructor 02
       FlightSection flightSection2 = new FlightSection(SeatClass.ECONOMY);
       System.out.println(flightSection2);
       
       //Test Getters
        System.out.println(flightSection2.getSeatClass());
       

    }
    
}
