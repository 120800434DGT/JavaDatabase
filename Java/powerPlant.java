import java.util.Scanner;
import java.io.*;


public class powerPlant {
    static String [] country = new String [11222];
    static String [] name = new String [11222];
    static double [] megawatts = new double [11222];
    static String [] powerType = new String [11222];
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        readFile();   
        double minPower = findMin(megawatts);
        System.out.println(minPower);
        int lowPower = findLowPower(megawatts);
        System.out.println(lowPower);
        int max = findMaxPos(megawatts);
        System.out.println(name[max] + "," + country[max]);
    }
    
    public static void readFile () throws FileNotFoundException {
        String fileName = "power.csv";
        Scanner fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
        fileScanner.useDelimiter("[\\r\\n,]+");
        
        for (int currentLine = 0; currentLine < 11222; currentLine ++){
            country[currentLine] = fileScanner.next();
            name[currentLine] = fileScanner.next();
            megawatts[currentLine] = fileScanner.nextDouble();
            powerType[currentLine] = fileScanner.next();
        }
        fileScanner.close();
    }
    public static double findMin (double [] megawatts){
        double min = megawatts[0];
        for (int index = 1; index < megawatts.length; index++){
            if(megawatts[index]<min) {
                min = megawatts[index];
            }
        }
        return min;
    }
    public static int findLowPower (double [] megawatts){
        int count = 0;
        for (int index = 0; index < megawatts.length; index++){
            if(megawatts[index]<100.0) {
                count = count + 1;
            }
        }
        return count;
    }
    public static int findMaxPos (double[] megawatts2) {
        int maxIndex = 0;
        for (int index = 1; index < megawatts2.length; index++){
            if(megawatts2[index]>megawatts2[maxIndex]) {
                maxIndex = index;      
            }
        }
        return maxIndex;
    }
    }

