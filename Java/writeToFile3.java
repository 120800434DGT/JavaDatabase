import java.util.Scanner;
import java.io.*;

public class writeToFile3 {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        
        String fileName = "writeExample.txt";

        File writeFile = new File(fileName);

              if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        String msg = "";

        System.out.println("Please enter the water temp");
        int temp = keyboard.nextInt(); keyboard.nextLine();
        if (temp>=100) {msg = "Gas";}
        else if (temp<=0) {msg = "Solid";}
        else msg = "Liquid"; 

        
        bw.write("At " + temp + " degrees centigrade water will be a " + msg);
       
      

        bw.close();
    }
}
