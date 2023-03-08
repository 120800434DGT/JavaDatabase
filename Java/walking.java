import java.util.Scanner;
import java.io.*;

class members {
    String forename;
    String surname;
    Double distance;

}

public class walking {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)throws IOException {
        String fileName = "members.txt";
        Scanner fileScanner = null;
        members [] walkers = new members[20];

     
        try {
            fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
            fileScanner.useDelimiter("[\\r\\n,]+");
            int currentLine = 0;
            while (fileScanner.hasNext()){
                walkers[currentLine] = new members();
                walkers[currentLine].forename = fileScanner.next();
                walkers[currentLine].surname = fileScanner.next();
                walkers[currentLine].distance = fileScanner.nextDouble();               
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
           
            double max = findMaxPos(walkers);
            System.out.println("The most distance walked is " + max);
            
            winners(walkers, max);
            
        
        
        }
    



    public static double findMaxPos (members[] walkers) {
        double max = walkers[0].distance;
        for (int index = 1; index < walkers.length; index++){
            if(walkers[index].distance>max) {
                max = walkers[index].distance;
            }
        }
        return max;
    }
    public static void winners (members [] walkers ,double max) throws IOException {     
        File writeFile = new File("results");

        if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);   
        for (int index = 0; index < walkers.length; index++){
            if(walkers[index].distance>max*0.7) {
                
                bw.write(walkers[index].forename + " ");
                bw.write(walkers[index].surname);
                bw.newLine();
            }
        }
        bw.newLine();
        for (int index = 1; index < walkers.length; index++){
            int marathon = (int) (walkers[index].distance/26.22); 
            bw.write(walkers[index].forename + " " + walkers[index].surname + " " + marathon );
            bw.newLine();
         }
         bw.close();
        
    }
    

}

