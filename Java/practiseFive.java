import java.util.Scanner;

public class practiseFive {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        int [] score = new int [6];
        int total = 0;
        for (int i = 0; i < score.length; i ++){
            System.out.println("please enter score " + (i+1) + ": ");
            score [i] = Keyboard.nextInt();
            total = score[i] + total;
        }
        System.out.println("Total score:" + total);
        for (int i = 0; i < score.length; i ++){
            System.out.println("please enter score " + (i+1)+ ": ");
            score [i] = Keyboard.nextInt();
    
        }
        Keyboard.close();
    }

}
