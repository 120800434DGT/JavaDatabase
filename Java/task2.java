import java.util.Scanner;

public class task2 {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Double [] testing1 = {12.0, 13.0, 15.0, 2.0, 3.0, 15.0, 99.0};
        Double [] testing2 = {1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 2.0, 1.0, 1.0, 1.0, 23.0, 4.0, 5.0, 6.0, 78.0, 9.0, 0.0, 0.0};
        String [] nameTesting1 = {"Lachlan", "Sam", "Michael", "Daniel", "Jack", "Luan", "Jordan"};
        
        Double maxValue = findMaxNumber(testing1);
        int maxPosition = findMaxPos(testing1);
        
        System.out.println ("the person with the highest prelim grade is: " + nameTesting1[maxPosition] + " scoring "  + maxValue);
        
        Double minValue = findMinNumber(testing1);
        int minPosition = findMinPos(testing1);
        
        System.out.println ("the person with the lowest prelim grade is: " + nameTesting1[minPosition] + " scoring "  + minValue);
        
        int noOnes = countOccurances(testing2, 1.0);
        
        System.out.println ("there are:" + noOnes);
        
        Boolean findVal  = linearSearch(testing2, 1.0);
        System.out.println ("The target's appearance is " + findVal);
    }

    public static Double findMaxNumber (Double [] numbers) {
        Double max = numbers[0];
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]>max) {
                max = numbers[index];
            }
        }
        return max;
    }

    public static int findMaxPos (Double [] numbers) {
        int maxIndex = 0;
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]>numbers[maxIndex]) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    public static int countOccurances (Double [] numbers, Double target) {
        int count = 0;
        for (int index = 0; index < numbers.length; index++){
            if(numbers[index]==target) {
                count = count + 1;
            }
        }
        return count;
    }

    public static Double findMinNumber (Double [] numbers) {
        Double min = numbers[0];
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]<min) {
                min = numbers[index];
            }
        }
        return min;
    }
    public static int findMinPos (Double [] numbers) {
        int minIndex = 0;
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]<numbers[minIndex]) {
                minIndex = index;      
            }
        }
        return minIndex;
    }
    public static Boolean linearSearch(Double [] numbers, Double target) {
        Boolean Ocurrance = false;
        for (int index = 0; index < numbers.length; index++){
            if(numbers[index]==target) {
                Ocurrance = true;
            }
        }
        return Ocurrance;
    }




}
