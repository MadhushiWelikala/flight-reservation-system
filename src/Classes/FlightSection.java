 package Classes;

/**
 *
 * @author Madhushi
 */
public class FlightSection {

    private SeatClass seatClass;
    
    //constructor 01
    public FlightSection() {
        this.seatClass = null;
    }  
    
    //constructor 02
    public FlightSection(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

//    public void setSeatClass(String seatID) {
//        //this.seatClass = seatClass;        
//        String columnChar = ""; //Character of the seat column
//        int rawNumber = 0;  //consists of two numbers
//        
//        columnChar = String.valueOf(seatID.charAt(0));
//        rawNumber = Integer.parseInt(seatID.substring(1));
//        
//        if(rawNumber>=1 && rawNumber<=4){
//            switch(columnChar){
//                case "A":
//                case "B":
//                case "G":
//                case "H":
//                    this.seatClass = SeatClass.FIRST;
//                    break;
//                default:
//                    System.out.println("Invalid Seat ID");
//                    break;
//            }
//        }
//        else if(rawNumber>=5 && rawNumber<=12){
//            switch(columnChar){
//                case "A":
//                case "B":
//                case "C":
//                case "F":
//                case "G":
//                case "H":
//                    this.seatClass = SeatClass.BUSINESS;
//                    break;
//                default:
//                    System.out.println("Invalid Seat ID");
//                    break;
//            }
//        }
//        else if(rawNumber>=13 && rawNumber<=60){
//            switch(columnChar){
//                case "A":
//                case "B":
//                case "C":
//                case "D":
//                case "E":
//                case "F":
//                case "G":
//                case "H":
//                    this.seatClass = SeatClass.ECONOMY;
//                    break;
//                default:
//                    System.out.println("Invalid Seat ID");
//                    break;
//            }
//        }
//        
//    }

    @Override
    public String toString() {
        return "Seat Class: " + seatClass ;
    }
    
    
    
    
    

    
}
