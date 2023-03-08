import java.util.Scanner;
import java.io.*;

public class readingFun {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
      final int STUDENT_NUMBER = 60;

      String [] email = new String [STUDENT_NUMBER];
      String [] fName = new String [STUDENT_NUMBER]; 
      String [] sName = new String [STUDENT_NUMBER];
      double [] examScore = new double [STUDENT_NUMBER];

      String fileName = "rawpupildata.csv";
      
      Scanner fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
      
      fileScanner.useDelimiter("[\\r\\n,]+");

      for(int currentline = 0; currentline < STUDENT_NUMBER; currentline ++) {
        email[currentline] = fileScanner.next();
        fName[currentline] = fileScanner.next();
        sName[currentline] = fileScanner.next();
        examScore[currentline] = fileScanner.nextDouble();
      }

      for (int index = 0; index < STUDENT_NUMBER; index ++){
        System.out.println((index + 1) + " email address is " + email[index] + " scored " + examScore[index]);
      }

    }
}

