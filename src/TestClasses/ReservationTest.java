package TestClasses;

import Classes.Address;
import Classes.Name;
import Classes.Passenger;
import Classes.Reservation;
import Classes.Seat;

/**
 *
 * @author Madhushi
 */
public class ReservationTest {

    public static void main(String[] args) {
        // test constructor01
//        Reservation reservation1 = new Reservation();
        //System.out.println(reservation1);
        
        Seat seat1 = new Seat("A1", true);
        Seat seat2 = new Seat("A2", true);
//        Seat seat3 = new Seat("A3", true);
        
        Name name1 = new Name("Madhushi","Welikala");
        Address address1 = new Address("Madulawa", "Padukka");
        Passenger passenger1 = new Passenger(name1, address1, "071 683 6774");
        
        Name name2 = new Name("Sajini","Senaratna");
        Address address2 = new Address("HighLevel Rd.", "Kottawa");        
        Passenger passenger2 = new Passenger(name2, address2, "071 683 6774");
        
//        Name name3 = new Name("Uditha","Karunarathna");
//        Address address3 = new Address("HighLevel Rd.", "Godagama");        
//        Passenger passenger3 = new Passenger(name3, address3, "071 683 6774");
        
        Passenger[] passengers1 =  {passenger1, passenger2};                                         //new Passenger[2];
        Seat[] reservedSeats1 = {seat1, seat2};                             //new String[2];
        Reservation reservation1 = new Reservation(6, 2, passengers1, "ML654", "28 dec 2016", reservedSeats1);
        System.out.println(reservation1);
        
        
        //test setters
//        reservation1.setReservationNumber(5);
//        reservation1.setNumberOfPassengers(2);        
//        reservation1.setPassengers(passengers1);
//        reservation1.setFlightNumber("UL528");
//        reservation1.setDepartureDate(2016, 12, 25);        
        //reservation1.setReservedSeats(reservedSeats1);       

//        System.out.println(reservation1);
        
//        Passenger[] passengers2 = {passenger1, passenger2, passenger3};                                                      //new Passenger[3];
//        String[] reservedSeats2 = {seat1.getSeatID(), seat2.getSeatID(), seat3.getSeatID()};                            //new String[3];
        
        //test constructor02
      /*  Reservation reservation2 = new Reservation(6, 3, passengers2, "ML654", "28 dec 2016", reservedSeats2);
        System.out.println(reservation2);
        
        //test getters
        System.out.println(reservation2.getReservationNumber());
        System.out.println(reservation2.getNumberOfPassengers());
        reservation2.getPassengers();
        System.out.println(reservation2.getFlightNumber());
        System.out.println(reservation2.getDepartureDate());
        reservation2.getReservedSeats();
        */

    }
    
}
