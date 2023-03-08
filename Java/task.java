import java.util.Scanner;

public class task {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        int [] testing1 = {12, 13, 15, 2, 3, 15, 99};
        int [] testing2 = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 2, 1, 1, 1, 23, 4, 5, 6, 78, 9, 0, 0};
        String [] nameTesting1 = {"Lachlan", "Sam", "Michael", "Daniel", "Jack", "Luan", "Jordan"};
        
        int maxValue = findMaxNumber(testing1);
        int maxPosition = findMaxPos(testing1);
        
        System.out.println ("the person with the highest prelim grade is: " + nameTesting1[maxPosition] + " scoring "  + maxValue);
        
        int minValue = findMinNumber(testing1);
        int minPosition = findMinPos(testing1);
        
        System.out.println ("the person with the lowest prelim grade is: " + nameTesting1[minPosition] + " scoring "  + minValue);
        
        int noOnes = countOccurances(testing2, 1);
        
        System.out.println ("there are:" + noOnes);
        
        Boolean findVal  = linearSearch(testing2, 1);
        System.out.println ("The target's appearance is " + findVal);
    }

    public static int findMaxNumber (int [] numbers) {
        int max = numbers[0];
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]>max) {
                max = numbers[index];
            }
        }
        return max;
    }

    public static int findMaxPos (int [] numbers) {
        int maxIndex = 0;
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]>numbers[maxIndex]) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    public static int countOccurances (int [] numbers, int target) {
        int count = 0;
        for (int index = 0; index < numbers.length; index++){
            if(numbers[index]==target) {
                count = count + 1;
            }
        }
        return count;
    }

    public static int findMinNumber (int [] numbers) {
        int min = numbers[0];
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]<min) {
                min = numbers[index];
            }
        }
        return min;
    }
    public static int findMinPos (int [] numbers) {
        int minIndex = 0;
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]<numbers[minIndex]) {
                minIndex = index;      
            }
        }
        return minIndex;
    }
    public static Boolean linearSearch(int [] numbers, int target) {
        Boolean Ocurrance = false;
        for (int index = 0; index < numbers.length; index++){
            if(numbers[index]==target) {
                Ocurrance = true;
            }
        }
        return Ocurrance;
    }




}
