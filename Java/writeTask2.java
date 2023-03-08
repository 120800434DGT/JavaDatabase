import java.util.Scanner;
import java.io.*;

public class writeTask2 {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)throws IOException {
        
        int [] numbers = {17, 9, 23, 4, 3, 2, 5, 6, 7, 7, 13, 100, 12};
        String [] names = {"James" , "Tom", "Cameron", "Zoe", "Mia", "Robyn", "Alexander", "Euan", "Andrew", "Cameron"};
        String fileName = "writeExample.txt";

        File writeFile = new File(fileName);

              if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        int max = findMaxNumber(numbers);
        int minPos = findMinPos(numbers);
        int count = countOccurances(numbers);
        System.out.println("Enter a name");
        String target = keyboard.nextLine();
        boolean name = linearSearch(names, target);

        bw.write("The max is " + max);
        bw.newLine();
        bw.write("The location of the min is " + minPos);
        bw.newLine();
        bw.write("The number of 7s is " + count);
        bw.newLine();
        bw.write("Name found: " + name);
        bw.close();
        // Find and write the highest number to a file
            // 1. Max = numbers[0]
            // 2. fixed loop for index 1 to lenfth of numbers start
            // 3.   if (max < numbers[index]) then
            // 4.       max = numbers[index]
            // 5.   end if 
            // 6. end loop
            // 7. write the maximum value is & max to file

            

        // Find and write the position of the lowest number to file
            // 1. minPos = 0
            // 2. fixed loop for index 1 to lenfth of numbers start
            // 3.   if (numbers[minPos] > numbers[index]) then
            // 4.       minPos = index
            // 5.   end if 
            // 6. end loop
            // 7. write the minimum value is at & minPos to file

        // Find and write the number of 7s in the array to file
            // 1. count = 0
            // 2. fixed loop for index 0 to lenfth of numbers start
            // 3.   if (numbers[index] == 7) then
            // 4.       count = count + 1
            // 5.   end if 
            // 6. end loop
            // 7. write the number of 7s & count to file
            
        // Get a name from the keyboard and write if it is in the list of names to the file
            // 1. name = STRING from keyboard
            // 2. found BOOLEAN initially false
            // 3. fixed loop for index 0 to lenfth of names start
            // 4.   if (names[index].equals(name)) then
            // 5.       found = true
            // 6.   end if 
            // 7. end loop
            // 8. if (found = true)
            // 9.   write the person & name & is in the list
            //10. else
            //11.   write the person & name & is not in the list
            //12. end if
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
    public static int findMinPos (int [] numbers) {
        int minIndex = 0;
        for (int index = 1; index < numbers.length; index++){
            if(numbers[index]<numbers[minIndex]) {
                minIndex = index;      
            }
        }
        return minIndex;
    }
    public static int countOccurances (int [] numbers) {
        int count = 0;
        for (int index = 0; index < numbers.length; index++){
            if(numbers[index]==7) {
                count = count + 1;
            }
        }
        return count;
    }
    public static Boolean linearSearch(String [] names, String target) {
        Boolean Ocurrance = false;
        for (int index = 0; index < names.length; index++){
            if(names[index].equals(target)) {
                Ocurrance = true;
            }
        }
        return Ocurrance;
    }
}