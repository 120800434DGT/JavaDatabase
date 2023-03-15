import java.util.Scanner;
import java.io.*;

public class java {
    static String [] ID = new String[30];
            static String [] location = new String[30];
            static String [] forename = new String[30];
            static String [] surname = new String[30];
            static int [] jacks = new int[30];       
    static Scanner keyboard = new Scanner(System.in);
    class beach {
        String name;
        int rating;
        }
    public static void main(String[] args)throws FileNotFoundException,IOException {
        System.out.println("watcha wanna do");
        String watchadoin = keyboard.nextLine();
        if (watchadoin.equalsIgnoreCase("athlete")) {
            athlete();
        }
        beach();
    }
    
    public static void athlete ()throws FileNotFoundException,IOException{              
                readFile();
                bib(ID,location,forename,surname);}
            
            
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
        
        
                   
                        public static void beach; {
                            String fileName = "beachData.csv";
                            Scanner fileScanner = null;
                            beach [] beaches = new beach[973];
                            

                            try {
                                fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
                                fileScanner.useDelimiter("[\\r\\n,]+");
                                int currentLine = 0;
                                while (fileScanner.hasNext()){
                                    beaches[currentLine] = new beach();
                                    beaches[currentLine].name = fileScanner.next();
                                    beaches[currentLine].rating = fileScanner.nextInt();                   
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
                                double average = avg(beaches);
                            System.out.println(average);
                            desiredRating(beaches);

                            
                            }     
                            

                            
                        
                                
                            
                        
                        public static void desiredRating(beach [] beaches) {
                            System.out.println("Enter your desired rating");
                            int choice = keyboard.nextInt();
                            for (int index = 0; index < beaches.length; index++){
                                if (choice == beaches[index].rating) {
                                    int spacePos = 0;
                                    int counter = 0;
                                    Boolean found = false;
                                    while (found == false && counter < beaches[index].name.length()) {
                                        char charValue = beaches[index].name.charAt(counter);
                                        int asciValue = (int) charValue;
                                        if (asciValue == 32) {
                                            spacePos = counter;
                                            found = true;
                                        }
                                        counter++;
                                    }

                                    
                                    if (spacePos == 0) {
                                        System.out.println(beaches[index].name);

                                    }
                                    else {
                                        System.out.println(beaches[index].name.substring(0, spacePos));
                                    }
                                    //System.out.println(beaches[index].name);
                                }
                            }
                        } 

                        
                        public static double avg (beach [] beaches){
                            double avg = 0;
                            int count =0;

                            for (int index = 0; index < beaches.length; index++){
                                if (beaches[index].rating != 5) {
                                    avg = avg + beaches[index].rating;
                                    count = count + 1;
                                }
                            }
                            avg = avg/count;
                            return avg;
                        }
                    }   



                            

    

