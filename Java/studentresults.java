import java.util.Scanner;
import java.io.*;

public class studentresults {
    static Scanner keyboard = new Scanner(System.in);

    //global arrays created
    static String [] forename = new String[50];
    static String [] surname = new String[50];
    static int [] maths = new int[50];
    static int [] science = new int[50];
    static int [] english = new int[50];
    static int [] history = new int[50];

    public static void main(String[] args) throws IOException  {
        
        readFile();
        int [] total = calcTotal(maths,science,english,history);
        int max = highScore(total);
        System.out.println("\n" + forename[max] + " " + surname[max] + " got the highest score \n");
        int count = countHigh(total);
        System.out.println(count + " Students scored 250 or more \n");
        writeFile(count,total);
    
    }
    
    //files read into parallel arrays
    public static void readFile () throws FileNotFoundException {
        
        String fileName = "studentResults.csv";
        Scanner fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
        fileScanner.useDelimiter("[\\r\\n,]+");
        
        for (int currentLine = 0; currentLine < 50; currentLine ++){
            forename[currentLine] = fileScanner.next();
            surname[currentLine] = fileScanner.next();
            maths[currentLine] = fileScanner.nextInt();
            science[currentLine] = fileScanner.nextInt();
            english[currentLine] = fileScanner.nextInt();
            history[currentLine] = fileScanner.nextInt();
        }
        fileScanner.close();
    }
    //total scores calculated
        public static int [] calcTotal(int [] math,int [] scienc,int [] englis,int [] histor) {
        
            int [] total = new int[50];
        for (int index = 0; index < 50; index++){
            total[index] = math[index] + scienc[index] + englis[index] + histor[index];
            }
            return total;
        }
    //highest score found    
        public static int highScore (int [] numbers) {
            int maxIndex = 0;
            for (int index = 1; index < numbers.length; index++){
                if(numbers[index]>numbers[maxIndex]) {
                    maxIndex = index;
                }
            }
            return maxIndex;
        }
    //scores over 250 counted    
        public static int countHigh (int [] numbers) {
            int count = 0;
            for (int index = 0; index < numbers.length; index++){
                if(numbers[index]>250) {
                    count = count + 1;
                }
            }
            return count;
        }
    //results written to file    
        public static void writeFile (int count, int [] total)  throws IOException{
            String fileName = "busses.csv";

            File writeFile = new File(fileName);

            if(!writeFile.exists()) {
            writeFile.createNewFile();}

            FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (int index = 0; index < count; index++){
                bw.write(forename[index] + "," + surname[index] + ",");
                
                int ModSum = total[index] %2;
                
                if (ModSum == 1) {
                    bw.write("ODD");
                }
                else { bw.write("EVEN");}
                bw.newLine();
            }
            bw.close();

        }

    }


