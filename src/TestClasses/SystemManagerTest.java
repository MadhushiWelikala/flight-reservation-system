package TestClasses;

import Classes.SystemManager;

/**
 *
 * @author Madhushi
 */
public class SystemManagerTest {

public static void main(String[] args) {
            SystemManager test1 = new SystemManager("flightinfo.txt");
           //test1.readFlightSeatDetails("QR 0655");
           test1.saveFlightInfo();
           
          // test1.setFlightSeatDetails();
//            test1.getAirportDetails();
//            test1.getAirLineDetails();
//            test1.getFlightDetails();
//            test1.getSeatDetails("QR 1675");
                
//            test1.setFlights();
//            test1.setSeat();
    }

}
