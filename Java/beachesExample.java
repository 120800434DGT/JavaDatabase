import java.util.Scanner;
import java.io.*;

class BeachData {
    String name;
    int rating;
}
public class beachesExample {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        BeachData [] theBeaches = readBeachesFromFile();
        double averageRating = calculateaverageRating(theBeaches);
        displayAverage(averageRating);
        displayRatedBeaches(theBeaches);
    }

    public static void displayRatedBeaches( BeachData [] beaches){
        // Procedure to take in a beach rating and display the name of all 
        // beaches tested with that rating
        System.out.println("Plese enter the beach rating 1 to 5");
        int userRating = keyboard.nextInt(); keyboard.nextLine();
        while (userRating < 1 || userRating >5){
            System.out.println("Plese enter the beach rating 1 to 5");
            userRating = keyboard.nextInt(); keyboard.nextLine();
        }
        for (int index = 0; index < beaches.length; index ++){
            if (beaches[index].rating == userRating){
                int spacePos = 0;
                for (int character = 0; character < beaches[index].name.length(); character ++) {
                    char currentLetter = beaches[index].name.charAt(character);
                    int ASCIIletter = (int) currentLetter;
                    if (ASCIIletter == 32 && spacePos == 0) {
                        spacePos = character;
                    }
                }
                if (spacePos == 0){
                    System.out.println(beaches[index].name);
                } else {
                    System.out.println(beaches[index].name.substring(0,spacePos));
                }
            }
        }
    }
    public static void displayAverage (double avgRating){
        System.out.println("The average rating for all rated beaches is: " + avgRating);
    }
    public static double calculateaverageRating (BeachData [] beaches){
        int total = 0;
        int counter = 0;
        for (int index = 0; index < beaches.length; index ++){
          if (beaches[index].rating != 5){
            total = total + beaches[index].rating;
            counter = counter + 1;
          }  
        }
        double average = total / (double) counter; // double to force real number division
        return average;
    }

    public static BeachData[] readBeachesFromFile() {
        // This function will read the contents of the beachData.csv file
        // into a tempArray of BeachData records and return that array

        String fileName = "beachData.csv";
        Scanner fileScanner = null;
        BeachData [] tempArray = new BeachData[973];

        try{
            fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
            fileScanner.useDelimiter("[\\r\\n,]+");
            int currentLine = 0;
            while (fileScanner.hasNext()){
                tempArray[currentLine] = new BeachData();
                tempArray[currentLine].name = fileScanner.next();
                tempArray[currentLine].rating = fileScanner.nextInt();
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
