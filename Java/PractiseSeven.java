import java.util.Scanner;
public class PractiseSeven {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        String [] name = new String [4];
        int [] age = new int [4];

        

        for (int index =0; index < name.length; index++){
           
            System.out.println("Whatcha name");
            name[index] = Keyboard.nextLine();
            System.out.println("Whatcha age");
            age[index] = Keyboard.nextInt();
            Keyboard.nextLine();
        }
        System.out.println("List");
        for (int index =0; index < name.length; index++){
            if (age[index] < 12 ){
                System.out.println(name[index] + " - Junior ");
            } else if (age[index] > 17 ){
                System.out.println(name[index] + " - Senior ");
            } else {
                System.out.println(name[index] + " - Teen ");
            }

          
        
        
        
        }
        


        Keyboard.close();
    }

}