package Classes;

/**
 * Class Name : Airport
 * @author Madhushi
 * Purpose : To maintain information of an Airport. The maintained 
 *           information are, the airport ID, city and country.
 */
public class Airport {
    private String airportID;   //three letters
    private String city;
    private String country;
    
    //constructor01
    public Airport() {
        this.airportID = "";    //three letter ID
        this.city = "";
        this.country = "";
    }

    //constructor02
    public Airport(String airportID, String city, String country) {
        
        this.setAirportID(airportID);
        this.setCity(city);
        this.setCountry(country);
    }

    //Method name : setAirportID
    //Purpose : To asign the variable airportID with and ID 
    //Pre condition : The variable airportID is not containing an ID
    //Post condition : The variable airportID is containing an ID
    public void setAirportID(String airportID) {             
        
        if(airportID.matches("[a-zA-Z]+$") && airportID.length()==3){
            this.airportID = airportID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airport ID");
        }
          
    }

    public void setCity(String city) {
        if (city.matches("[a-zA-Z ]+$")) {
            this.city = city;
        }
        else{
            System.out.println("Invalid City Name");
        }
    }

    public void setCountry(String country) {
        if (country.matches("[a-zA-Z ]+$")) {
            this.country = country;
        }
        else{
            System.out.println("Invalid Airline Name");
        }
    }

    public String getAirportID() {
        return airportID; //returns airportID in capitals
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return this.getAirportID() + "," + this.getCity() + "," + this.getCountry();
    }
    
    
    
}
