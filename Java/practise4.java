import java.util.Scanner;
public class practise4 {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);

        int [] odd = {1,3,5,7,9,11,13,15,17,19,21};
        System.out.println("Please enter the first number");
        int num = Keyboard.nextInt();

        System.out.println("odd numbers list " + odd[num] );
    


        Keyboard.close();
    }
}
