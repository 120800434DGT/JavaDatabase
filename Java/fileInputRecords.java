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

public class fileInputRecords {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        String fileName = "booking.csv";
        Scanner fileScanner = null;
        Booking [] bookingList = new Booking[150];

        try{
            fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
            fileScanner.useDelimiter("[\\r\\n,]+");
            int currentLine = 0;
            while (fileScanner.hasNext()){
                bookingList[currentLine] = new Booking();
                bookingList[currentLine].bookingNo = fileScanner.next();
                bookingList[currentLine].adultTicket = fileScanner.nextInt();
                bookingList[currentLine].childTicket = fileScanner.nextInt();
                bookingList[currentLine].concessionTicket = fileScanner.nextInt();
                bookingList[currentLine].customerID = fileScanner.next();
                bookingList[currentLine].flightID = fileScanner.next();
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

        for (int index = 0; index < bookingList.length; index ++) {
            System.out.println((index + 1) + " You have booked " + bookingList[index].childTicket + " child tickets");
        }
    }
}
