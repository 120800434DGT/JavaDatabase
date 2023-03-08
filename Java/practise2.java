import java.util.Scanner;
public class practise2 {

    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        
        System.out.println("Please enter your house number");
        int houseNo = Keyboard.nextInt();
        Keyboard.nextLine();
        
        System.out.println("Please enter your street name");
        String street = Keyboard.nextLine();
        
        System.out.println("Please enter your town name");
        String town = Keyboard.nextLine();
        
        System.out.println(houseNo + "," + street + "," + town);
        Keyboard.close();

    }
}
