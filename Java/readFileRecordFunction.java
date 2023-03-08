import java.util.Scanner;
import java.io.*;

class Booking {
    String bookingNo;
    int adultTicket;
    int childTicket;
    int concessionTicket;
    String customerID;
    String flightID;
}

public class readFileRecordFunction {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        
        Booking [] customers = readBookingsFromFile();
        displayChildTickets(customers);
    
    }

    public static void displayChildTickets (Booking[] list) {
        for (int index = 0; index < list.length; index ++){
            if (list[index].childTicket > 0) {
                System.out.println(list[index].customerID + " " + list[index].childTicket);
            }
        }
    }
    public static Booking[] readBookingsFromFile() {
        String fileName = "booking.csv";
        Scanner fileScanner = null;
        Booking [] tempArray = new Booking[150];

        try{
            fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
            fileScanner.useDelimiter("[\\r\\n,]+");
            int currentLine = 0;
            while (fileScanner.hasNext()){
                tempArray[currentLine] = new Booking();
                tempArray[currentLine].bookingNo = fileScanner.next();
                tempArray[currentLine].adultTicket = fileScanner.nextInt();
                tempArray[currentLine].childTicket = fileScanner.nextInt();
                tempArray[currentLine].concessionTicket = fileScanner.nextInt();
                tempArray[currentLine].customerID = fileScanner.next();
                tempArray[currentLine].flightID = fileScanner.next();
                currentLine = currentLine + 1;
            }
        }

        catch (FileNotFoundException error) {
            System.out.println("file not found " + error);
        }

        finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }

        return tempArray;
    }
}
