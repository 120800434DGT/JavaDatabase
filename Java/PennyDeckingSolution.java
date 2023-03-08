import java.util.Scanner;
import java.io.*;

//Record structure to store deck information
class Deck {
    String name;
    double length;
    double width;
    int price;
}

public class PennyDeckingSolution {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Deck [] decksDataDecks = readDecksFromFile();
        int choice;
        // This will continually ask the user for a menu choice 1,2,3,4 
        // until they enter a valid number
        do{
        System.out.println("Enter 1: to find the cheapest garden deck");
        System.out.println("Enter 2: to display the names of gardern decks over a certain length");
        System.out.println("Enter 3: to display the number of garden decks that are available over a certain area");
        System.out.println("Enter 4; to quit the program");
        choice = keyboard.nextInt(); keyboard.nextLine();
        while (choice < 1 || choice > 4) {
            System.out.println("Error: the choice must be 1,2,3,4");
            System.out.println("Enter 1: to find the cheapest garden deck");
            System.out.println("Enter 2: to display the names of gardern decks over a certain length");
            System.out.println("Enter 3: to display the number of garden decks that are available over a certain area");
            System.out.println("Enter 4; to quit the program");
            choice = keyboard.nextInt(); keyboard.nextLine();
        }
        // these ifs run the correct sub program based on the value fo choice entered by the user
        if (choice == 1) {
        findCheapestDeck(decksDataDecks);
        } else if (choice == 2){
        findLongerDecks(decksDataDecks);}
        else if (choice == 3){
        findBiggerAreas(decksDataDecks);
        }
    } while (choice != 4);
    }

    public static Deck[] readDecksFromFile() {
        // This function will read the contents of the Decks.csv file
        // into a tempArray of Deck records and return that array

        String fileName = "Decks.csv";
        Scanner fileScanner = null;
        Deck [] tempArray = new Deck[6];

        try{
            fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
            fileScanner.useDelimiter("[\\r\\n,]+");
            int currentLine = 0;
            while (fileScanner.hasNext()){
                tempArray[currentLine] = new Deck();
                tempArray[currentLine].name = fileScanner.next();
                tempArray[currentLine].length = fileScanner.nextDouble();
                tempArray[currentLine].width = fileScanner.nextDouble();
                tempArray[currentLine].price = fileScanner.nextInt();
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

    public static void findCheapestDeck(Deck [] theDecks) {
        // This procedure will find the index of the record 
        // with the minimum price then display the name and 
        // price of that deck on the screen

        int minIndex = 0;
        for (int index = 1; index < theDecks.length; index ++){
            if (theDecks[index].price < theDecks[minIndex].price) {
                minIndex = index;
            }
        }
        System.out.println(theDecks[minIndex].name + " is the cheapest deck at £" + theDecks[minIndex].price);
    } 

    public static void findLongerDecks (Deck [] theDecks){
        // This procedure will get a valid number (2 - 15) from the user
        // then display a list of decks with a length attribute more 
        // than that entered number

        //this first section ask the user to enter the number until they enter a valid value
        System.out.println("Please enter the shortest deck you are looking for ");
        int targetLength = keyboard.nextInt(); keyboard.nextLine();
        while (targetLength < 2 || targetLength > 15) {
            System.out.println("Error: the length must be between 2 and 15 inclusive ");
            targetLength = keyboard.nextInt(); keyboard.nextLine();
        }

        //this section will find and display decks longer than the target
        System.out.println("The decks over " + targetLength + " long are:");
        for (int index = 0; index < theDecks.length; index ++) {
            if (theDecks[index].length >= targetLength){
                System.out.println(theDecks[index].name);
            }
        }
    }

    public static void findBiggerAreas (Deck [] theDecks) {
         // This procedure will get a valid number (4 - 80) from the user
         // then count and display the number of decks with a greater area

        //this first section ask the user to enter the number until they enter a valid value
        System.out.println("Please enter the minimum area you are looking for ");
        int targetArea = keyboard.nextInt(); keyboard.nextLine();
        while (targetArea < 4 || targetArea > 80) {
            System.out.println("Error: the area must be between 4 and 80 inclusive ");
            targetArea = keyboard.nextInt(); keyboard.nextLine();
        }

        // this section uses the count occurances algorithm to find the number of 
        // decks with a greater area than target

        int count = 0;
        for (int index = 0; index < theDecks.length; index ++){
            if((theDecks[index].length * theDecks[index].width) > targetArea){
                count = count + 1;
            }
        }
        System.out.println("There are " + count + " decks over " + targetArea + " metres squared");
        }

}
