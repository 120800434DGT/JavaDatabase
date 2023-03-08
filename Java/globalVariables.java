import java.util.Scanner;

public class globalVariables {
    static Scanner keyboard = new Scanner(System.in);

    // global variable for multivalue sub program return
    static String forename = "";
    static String surname;
    
    public static void main(String[] args) {
        getUserData();
        displayUserData(forename, surname);
    }

    public static void getUserData () {
        System.out.println("please enter your firstname");
        forename = keyboard.nextLine();
        System.out.println("please enter your surname");
        surname = keyboard.nextLine();
    }

    public static void displayUserData(String fname, String sname){
        System.out.println("welcome" + fname + " " + sname);
    }
}

