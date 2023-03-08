import java.util.Scanner;
public class practise3 {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Please enter the temperature of the water");
        int temp = Keyboard.nextInt();
        if (temp>99) 
        {System.out.println("At "+ temp + " degrees water will be a gas");}
        else if 
        (temp<0) {System.out.println("At "+ temp + " degrees water will be a solid");}
        else 
        System.out.println("At "+ temp + " degrees water will be a solid");

        Keyboard.close();



    }
}
