package Classes;

/**
 *
 * @author Madhushi
 */
public class Seat {
    private String seatID;    //rowNumber+columnCharacter
    private boolean status; //shows whether a seat is booked or not; true if reserved
    

     
    //constructor02
    public Seat(String seatID, boolean status) {
        this.seatID = seatID;
        this.status = status;
        
    }

    public void setSeatID(String seatID) {
        if(seatID.matches("[a-zA-Z0-9]+$") && seatID.length()==3){
            this.seatID = seatID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airline ID");
        }
        
        this.seatID = seatID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getSeatID() {       
        return seatID;
    }

    public boolean isStatus() {
       return status;
    }
    
    @Override
    public String toString() {
        return this.getSeatID() + "\t" + this.isStatus();
    }
    
    
    
    
}
