import java.util.Scanner;
import java.io.*;

public class Assignment {
    static Scanner keyboard = new Scanner(System.in);
    
    //Variable used for length of arrays and loops for better maintainability
    static int NUMBER = 26;
    
    //Global arrays declared for values to later be entered
    static String [] attraction = new String[NUMBER];
    static String [] category = new String[NUMBER];
    static int [] visitors = new int[NUMBER];
    static int [] daysOpen = new int [NUMBER];
    static String [] height = new String [NUMBER];

    public static void main(String[] args) throws FileNotFoundException,IOException {

        //Procedure called to read the file data
        readFile();

        //Procedure called to calculate the attractions with the least or most visitors and results are displayed
        findMinMax(visitors);
            
        //Procedure called to write to file the names of roller coasters that need service within 7 days
        writeToFile(attraction,category,daysOpen);
        
        //Function called to count the number of attractions with a height restriction of 1m or higher
        int restrictions = countOccurances(height);
        System.out.println("There are " + restrictions + " attractions with a height restriction over 1m tall");
    }
    
    //Data read in from file into parallel arrays
    public static void readFile () throws FileNotFoundException {
        
        String fileName = "attractions.csv";
        Scanner fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
        fileScanner.useDelimiter("[\\r\\n,]+");
        
        for (int currentLine = 0; currentLine < NUMBER; currentLine ++){
            
            attraction[currentLine] = fileScanner.next();
            category[currentLine] = fileScanner.next();
            visitors[currentLine] = fileScanner.nextInt();
            daysOpen[currentLine] = fileScanner.nextInt();
            height[currentLine] = fileScanner.next();
        }
        fileScanner.close();
    }
       
    //Highest and lowest values for amount of visitors is found
    public static void findMinMax (int [] numbers) {
        
        int minIndex = 0;
        int maxIndex = 0;
        
        for (int index = 1; index < numbers.length; index++){
            
            if(numbers[index]<numbers[minIndex]) {
                minIndex = index;      
            }

            if(numbers[index]>numbers[maxIndex]) {
                maxIndex = index;
            }
        }
    //Attractions with the most or least amount of visitors are found and displayed
        for (int index = 0; index < numbers.length; index++){
            
            if(numbers[index]==numbers[minIndex]) {
                System.out.println(attraction[index] + " is one of the least visited attractions with " + visitors[index] + " visitors");
            }
            if(numbers[index]==numbers[maxIndex]) {
                System.out.println(attraction[index] + " is the most visited attraction with " + visitors[index] + " visitors");
            }
        }
        
    }

    //Names of roller coasters that need service within 7 days is written to service file
    public static void writeToFile (String [] name,String [] type,int [] days) throws IOException {
        
        String fileName = "Service.csv";
        File writeFile = new File(fileName);

        if(!writeFile.exists()){
            
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int index = 0; index < name.length; index ++){
        
    //Roller coasters identified        
            if (type[index].equals("Roller Coaster")) {                
                int modDays = days[index] %90;
                
    //Roller coasters with 7 days or less until service are identified and written to file            
                if ((90 - modDays) <= 7 ) {
                    bw.write(name[index]);
                    bw.newLine();                    
                }                
            }        
        }
        bw.close();
    }
    
    //Number of attractions with height restiction of 1m or taller is counted
    public static int countOccurances (String [] numbers) {
        
        int count = 0;
        
        for (int index = 0; index < numbers.length; index++){
            
            int charValue = numbers[index].charAt(0);
            
            if (charValue == 49) {
                
                count++;
            }
        }
        return count;
    }
}
