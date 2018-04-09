package TestClasses;

import Classes.Address;
import Classes.Name;
import Classes.Passenger;

/**
 *
 * @author Madhushi
 */
public class PassengerTest {
    public static void main(String[] args) {
        
        //test constructor 01
        Passenger passenger1 = new Passenger();
        
        Name name1 = new Name("Madhushi","Welikala");
        Address address1 = new Address("Madulawa", "Padukka");
        //test setters
        passenger1.setName(name1);
        passenger1.setAddress(address1);
        passenger1.setTelephoneNumber("011 283 1716");
        System.out.println(passenger1);
        
        Name name2 = new Name("Sajini","Senaratna");
        Address address2 = new Address("HighLevel Rd.", "Godagama");
        //test constructor 02
        Passenger passenger2 = new Passenger(name2, address2, "071 683 6774");
        System.out.println(passenger2);
        
        //test getters
        System.out.println(passenger2.getName());
        System.out.println(passenger2.getAddress());
        System.out.println(passenger2.getTelephoneNumber());
    }
    
}
