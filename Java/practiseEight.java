
import java.util.Scanner;
public class practiseEight {
    public static void main(String[] args) {
        System.out.println("The Hypotenuse is "+ pythagoras( 10.0,5.0));
        System.out.println("The area is " + triangle(2, 3));
        validation(2, 9);
        System.out.println(title("Sir", "Daniel", "Thompson", "The Great"));
    }
    public static double pythagoras(double a,double b) {
        double c = 0.0;

        c=Math.sqrt((a*a)+(b*b));
        return c;
    }
    public static double triangle(double l, double b) {
    double a = 0.0;

    a = 0.5 * l * b;
    return a;
    }
    public static double validation(double min, double max) {
        Scanner Keyboard = new Scanner(System.in);
        double val;
        val = Keyboard.nextDouble();
        Keyboard.nextLine();
        while (val < min || val > max) {
            System.out.println("Please enter a correct number");
            val = Keyboard.nextDouble();
        }
        Keyboard.close();
        return val;
        }
    public static String title(String prefix, String forename, String surname , String suffix) {
        String name;
        name = prefix + forename + surname +  suffix;

        return name;

    }




}
