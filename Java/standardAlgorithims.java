/**
 * standardAlgorithims
 */
public class standardAlgorithims {

    public static void main(String[] args) {
        int [] numbers ={ 1, 2, 3, 4, 5};
        int max = findMax (numbers);
        int min = findMinIndex (numbers);
        System.out.println("The max is " + max);
        System.out.println("The min is " + min);
        linearSearch(numbers, 5);
   
    }


    public static int findMax (int [] list) {
        int max = 0;
        
        for (int i = 0; i < list.length;i++) {
            if (max < list[i]) {
                max = list[i]; 

            }
        }
        return max;
    }
    public static int findMinIndex (int [] list) {
        int min = 0;
        
        for (int i = 0; i < list.length;i++) {
            if ( list[i] < list[min]) {
                min = i; 
            }
        }
        return min;
    }
    public static void linearSearch (int [] list, int value){
        for (int i = 0; i < list.length; i++){
            if (value == list[i]){
                System.out.println(value + " Is in the array");
            } 

        }


    }

}