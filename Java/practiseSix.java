

import java.util.Scanner;
public class practiseSix {

    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        String [] names = {"Mellisa","Evelyn","Emmy","Karen","Margaret","Norma","Agnes","Robert","Billy","Arthur"};
        String [] answer = new String[10];

        System.out.println("who is going");

        for (int index =0; index < names.length; index++){
            System.out.println(names[index]+ "?");
            answer[index] = Keyboard.nextLine();

        }
        System.out.println("party list");
        for (int index =0; index < names.length; index++){
          if (answer[index].equals("y")){
            System.out.println(names[index]);
          }
        }
            


    
        Keyboard.close();
    }
}
