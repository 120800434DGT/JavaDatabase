import java.util.Scanner;
import java.io.*;




public class Golf {
    static String forename;
    static String surname;
    static String category;
    static String password;

    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)throws IOException {
        
        
        
        

        System.out.println("Enter Firstname");
        String firstname = keyboard.nextLine();
        System.out.println("Enter Lastname");
        String lastname = keyboard.nextLine();
        System.out.println("Are you junior,adult or senior?");
        String Newcategory = keyboard.nextLine();
        String Newpassword = checkPassword();
        System.out.println(Newpassword);
           
        String [] categoryArray = getCategory(firstname, lastname, Newcategory, Newpassword);
        counter(categoryArray);
    }     
        public static String [] getCategory (String firstname,String lastname,String Newcategory,String Newpassword) throws FileNotFoundException{
            String [] forenameArray = new String [11];
            String [] surnameArray = new String [11]; 
            String [] categoryArray = new String [11];
            String [] passwordArray = new String [11];

            String fileName = "golfMembers.txt";
           
            Scanner fileScanner = new Scanner (new BufferedReader (new FileReader(fileName)));
      
            fileScanner.useDelimiter("[\\r\\n,]+");
            for (int currentLine = 0; currentLine < 10; currentLine ++){
                forenameArray[currentLine] = fileScanner.next();
                surnameArray[currentLine] = fileScanner.next();
                categoryArray[currentLine] = fileScanner.next();
                passwordArray[currentLine] = fileScanner.next();
            }
            fileScanner.close();
            

            forenameArray[10]= firstname;
            surnameArray[10]= lastname;
            categoryArray[10]= Newcategory;
            passwordArray[10]= Newpassword;
            for (int index = 0; index < 11; index++){                
                System.out.println(forenameArray[index] + " " + surnameArray[index] + " " + categoryArray[index] + " " );
            }
            return categoryArray;

        }

        public static String checkPassword () {
            Boolean valid = false;
            System.out.println("Enter a valid password");
                String password = keyboard.nextLine();
            while (valid == false) {
                
                char charValue = password.charAt(0);
                int asciValue = (int) charValue;
                if (asciValue >= 65 && asciValue <= 90) {
                    charValue = password.charAt(password.length()-1);
                    asciValue = (int) charValue;
                    if (asciValue >=35 && asciValue <=37) {
                        valid = true;                       
                    }
                    else {
                        System.out.println("A valid password must start with a capital and end with a #,$ or a %");
                        password = keyboard.nextLine();
                    }
                }
                else 
                    {System.out.println("A valid password must start with a capital and end with a #,$ or a %");
                    password = keyboard.nextLine();} 
                }
                return password;
        } 
        public static void counter (String [] categoryArray ){
            int adultCounter = 0;
            int juniorCounter = 0;
            int seniorCounter = 0;
            for (int index = 0; index < categoryArray.length; index++){   
                if (categoryArray[index].equals("Adult")){
                    adultCounter++;
                } else if (categoryArray[index].equals("Junior")){
                    juniorCounter++;
                }
                else if (categoryArray[index].equals( "Senior")){
                    seniorCounter++;
                }
                
            }
            System.out.println("There are " + adultCounter + " Adults " + " There are " + juniorCounter + " Juniors " + " There are " + seniorCounter + " Seniors");
            
            

    }
}
    

