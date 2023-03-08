import java.util.Scanner;
import java.io.*;

public class writeToFile2 {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        
        String fileName = "writeExample.txt";

        File writeFile = new File(fileName);

              if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println("Please enter the number of carbons");
        int carbons = keyboard.nextInt();

        int hydrogen = carbons*2+2;
        int mass = carbons*12+hydrogen;
        
        bw.write("The atomic mass of C" + carbons + "H" + hydrogen + " is " + mass);
        

        bw.close();
    }
}
