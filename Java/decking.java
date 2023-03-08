import java.util.Scanner;
import java.io.*;

class decks {
String name;
double length;
double breadth;
int price;

}

public class decking {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        String fileName = "Decks.csv";
        Scanner fileScanner = null;
        decks [] deckList = new decks[6];
       

    try {
        fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
        fileScanner.useDelimiter("[\\r\\n,]+");
        int currentLine = 0;
        while (fileScanner.hasNext()){
            deckList[currentLine] = new decks();
            deckList[currentLine].name = fileScanner.next();
            deckList[currentLine].length = fileScanner.nextDouble();
            deckList[currentLine].breadth = fileScanner.nextDouble();
            deckList[currentLine].price = fileScanner.nextInt();       
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
        System.out.println(" Enter 1 to find the cheapest deck \n Enter 2 to display the names of garden decks over a certain length \n Enter 3 to display the number garden decks that are available over a certain area \n Enter 4 to quit");
        int choice = keyboard.nextInt();
        
        while (choice<1 || choice >4){
            System.out.println("Please enter a valid number");
            choice = keyboard.nextInt();
        }
        if (choice ==1) {
           int minPosition = findMinPos(deckList);
           System.out.println("The cheapest deck is " + deckList[minPosition].name + " at £" + deckList[minPosition].price);
        }
        else if (choice == 2) {
            System.out.println("Enter the minimum length");
            Double minlength = keyboard.nextDouble();
            System.out.println("The decks over " + minlength + "m are");
            decklength(deckList,minlength);
        }
        else if (choice == 3) {
            System.out.println("Enter the minimum area");
            Double minarea = keyboard.nextDouble();
            int count = deckcount(deckList, minarea);
            System.out.println("The numbers of decks over " + minarea + "meters squared are " + count);
            
        }
        else if (choice == 4) {
        System.out.println("Bye bye");
            
        }
        
    }
 
    public static int findMinPos (decks [] deck) {
        int minIndex = 0;
        for ( int index = 1; index < deck.length; index ++){
            if(deck[index].price<deck[minIndex].price) {
                minIndex = index;      
            }
        }
        return minIndex;
    }
    public static void decklength (decks [] deck, double minlength) {
        for (int index = 0; index < deck.length; index++){
            if (deck[index].length >= minlength){
                System.out.println(deck[index].name);

            }
        }

    }
    public static int deckcount (decks [] deck, double minarea) {
        int count = 0;
        for (int index = 0; index < deck.length; index++){
            if (deck[index].length*deck[index].breadth >= minarea){
                count = count + 1;

            }
        }
        return count;

    }


}
