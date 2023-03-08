import java.util.Scanner;
import java.io.*;

public class athletes {
    static String [] ID = new String[30];
    static String [] location = new String[30];
    static String [] forename = new String[30];
    static String [] surname = new String[30];
    static int [] jacks = new int[30];
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException,IOException {
        readFile();
        bib(ID,location,forename,surname);
    }
    
    public static void readFile () throws FileNotFoundException {
        String fileName = "athletes.csv";
        Scanner fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
        fileScanner.useDelimiter("[\\r\\n,]+");
        
        for (int currentLine = 0; currentLine < 30; currentLine ++){
            ID[currentLine] = fileScanner.next();
            location[currentLine] = fileScanner.next();
            forename[currentLine] = fileScanner.next();
            surname[currentLine] = fileScanner.next();
            jacks[currentLine] = fileScanner.nextInt();
        }
        fileScanner.close();
    }
    public static void bib (String [] ID,String [] location,String [] forename,String [] surname )  throws IOException{
        String fileName = "Bibvalues.csv";
        File writeFile = new File(fileName);

              if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for (int index = 0; index < 30; index++){
            char charValue = forename[index].charAt(0);
            int  ASCII = location[index].charAt(0);
            bw.write(ID[index] + "," + charValue + forename[index] + ASCII);
            bw.newLine();
        }

        bw.close();
    }
}
