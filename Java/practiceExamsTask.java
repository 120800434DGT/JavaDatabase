import java.io.*;
import java.util.Scanner;

public class practiceExamsTask {
        static Scanner keyboard = new Scanner(System.in);

        static String [] fornames = new String [50];
        static String [] surnames = new String [50];
        static int [] maths = new int [50];
        static int [] english = new int [50];
        static int [] science = new int [50];
        static int [] history = new int [50];

        public static void main(String[] args) throws IOException {
            
            readDataFromFile();
            int [] totals = calculateTotals(maths, english, history, science);
            findDisplayHigh(totals);
            int awardNumbers = countHighScores(totals);
            displyayAwards(awardNumbers);
            writeToCSV(fornames, surnames, totals);
        }
    
        public static void readDataFromFile() {
            String fileName = "studentResults.csv";
            Scanner fileScanner = null;
    
            try{
                fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
                fileScanner.useDelimiter("[\\r\\n,]+");
                int currentLine = 0;
                while (fileScanner.hasNext()){
                    fornames[currentLine]= fileScanner.next();
                    surnames[currentLine] = fileScanner.next();
                    maths[currentLine]= fileScanner.nextInt();
                    english[currentLine] = fileScanner.nextInt();
                    history[currentLine] = fileScanner.nextInt();
                    science[currentLine]= fileScanner.nextInt();
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
        }

        public static int [] calculateTotals(int [] ma, int [] eng, int [] his, int [] sci) {
            int [] totals = new int [50] ;
            for (int index = 0; index < totals.length; index ++){
                totals[index] = ma[index] + eng[index] + his[index] + sci[index];
            }
            return totals;
        }

        public static void findDisplayHigh (int [] scores){
            int max = scores[0];
            for (int index = 1; index < scores.length; index++){
                if (scores[index] > max){
                    max = scores[index];
                }
            }
            System.out.println("The highest Overall score was: " + max);
        }

        public static int countHighScores (int [] scores){
            int count = 0;
            for (int index = 0; index < scores.length; index ++){
                if (scores[index] > 250){
                    count = count + 1;
                }
            }
            return count;
        }

        public static void displyayAwards (int winners) {
            System.out.println("There were " + winners + " award winners");
        }

        public static void writeToCSV (String [] fname, String [] sname, int [] scores) throws IOException{
              
        String fileName = "busses.csv";

        File writeFile = new File(fileName);

        if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (int index = 0; index < scores.length; index ++){
            if (scores[index]%2 == 0){
            bw.write(fname[index] + "," + sname[index] + "," + "EVEN\n");
            } else {
            bw.write(fname[index] + "," + sname[index] + "," + "ODD\n");
            }
        }

        bw.close();
        }
    }
    

