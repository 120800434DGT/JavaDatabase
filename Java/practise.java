import java.util.Scanner;
public class practise {

    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Please enter the number of carbons");
        int carbons = Keyboard.nextInt();
        int carboons = carbons*2+2 + carbons*12;
        System.out.println("C"+ carbons + "H" + carbons*2+2 + " is " + carboons);

        Keyboard.close();
    }
}