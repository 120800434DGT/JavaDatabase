import java.util.Scanner;
import java.io.*;

public class WriteExampleSub {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        
        int [] numbers = {17, 9, 23, 4, 3, 2, 5, 6, 7, 7, 13, 100, 12};
        String [] names = {"James" , "Tom", "Cameron", "Zoe", "Mia", "Robyn", "Alexander", "Euan", "Andrew", "Cameron"};
 
        int minNum = findSmallest(numbers);
        writeSmall (minNum);
        System.out.println(names);
    }

    public static int findSmallest (int [] theNumbers) {
        int min = theNumbers[0];
        for(int index = 0; index < theNumbers.length; index ++){
            if (min > theNumbers[index]){
                min =theNumbers[index];
            }
        }
        return min;
    }
    
    public static void writeSmall (int writeNum) throws IOException {
        String fileName = "mimimumNum.txt";

        File writeFile = new File(fileName);

        if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("The minimum number in the list is " + writeNum);

        bw.close();
    }

}
