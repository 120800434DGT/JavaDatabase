import java.util.Scanner;

class Student {
    String forename;
    String surname;
    int [] scores = new int [5];



}
public class PractiseNine {
public static void main(String[] args) {
    Student aStudent = getStudentInfo();
    displayStudentInfo(aStudent);
    avg(aStudent);
}
    public static Student getStudentInfo() {   
        Scanner Keyboard = new Scanner(System.in);
        Student tempStudent = new Student();
        System.out.println("Please enter your forename");
        tempStudent.forename = Keyboard.nextLine();
        System.out.println("Please enter your surname");
        tempStudent.surname = Keyboard.nextLine();


        for (int i = 0; i < 5; i++) {
            System.out.println("Enter score " + (i + 1) );
           tempStudent.scores[i] = Keyboard.nextInt();
            while  ( tempStudent.scores[i] < 1 || tempStudent.scores[i]>100){
            System.out.println("Invalid score");
            tempStudent.scores[i] = Keyboard.nextInt();

            }

        }
        Keyboard.close();
        return tempStudent ;
        }
        public static void avg(Student tempStudent){
            
            int total = 0;

            for (int i = 0; i < tempStudent.scores.length; i ++) {
                total = total + tempStudent.scores[i];
            }


            double average = total / 5.0;

            System.out.println("The average score is " + average);
        }



        public  static void displayStudentInfo (Student person) {
            System.out.println("The students name is " + person.forename + " " + person.surname );
            System.out.println("Their average score is");

        }


}

