import java.io.*;
import java.util.Scanner;
class beach {
String name;
int rating;
}

public class beachy {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        String fileName = "beachData.csv";
        Scanner fileScanner = null;
        beach [] beaches = new beach[973];
        

        try {
            fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
            fileScanner.useDelimiter("[\\r\\n,]+");
            int currentLine = 0;
            while (fileScanner.hasNext()){
                beaches[currentLine] = new beach();
                beaches[currentLine].name = fileScanner.next();
                beaches[currentLine].rating = fileScanner.nextInt();                   
                currentLine = currentLine + 1;
            }
    
            } catch (FileNotFoundException error) {
                System.out.println("file not found " + error);
            }
            finally {
                if (fileScanner != null) {
                    fileScanner.close();
                }
            }
            double average = avg(beaches);
        System.out.println(average);
        desiredRating(beaches);

           
        }     
        

        
    
            
        
    
    public static void desiredRating(beach [] beaches) {
        System.out.println("Enter your desired rating");
        int choice = keyboard.nextInt();
        for (int index = 0; index < beaches.length; index++){
            if (choice == beaches[index].rating) {
                int spacePos = 0;
                int counter = 0;
                Boolean found = false;
                while (found == false && counter < beaches[index].name.length()) {
                    char charValue = beaches[index].name.charAt(counter);
                    int asciValue = (int) charValue;
                    if (asciValue == 32) {
                        spacePos = counter;
                        found = true;
                    }
                    counter++;
                }

                
                if (spacePos == 0) {
                    System.out.println(beaches[index].name);

                }
                else {
                    System.out.println(beaches[index].name.substring(0, spacePos));
                }
                //System.out.println(beaches[index].name);
            }
        }
    } 

    
    public static double avg (beach [] beaches){
        double avg = 0;
        int count =0;

        for (int index = 0; index < beaches.length; index++){
            if (beaches[index].rating != 5) {
                avg = avg + beaches[index].rating;
                count = count + 1;
            }
        }
        avg = avg/count;
        return avg;
    }
}   


