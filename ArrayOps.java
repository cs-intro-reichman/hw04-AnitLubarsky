public class ArrayOps {
    public static void main(String[] args) {
        // testFindMissingInt();
        // testSecondMaxValue();
        //testContainsTheSameElements();
        //testIsSorted();
    } 
    

    public static void  testFindMissingInt () {
        int missingNumber;
        int expectedNumber = 2;
        missingNumber = findMissingInt (new int[] {3, 0, 1});
        verifyMissingInt (missingNumber, expectedNumber);
      
        expectedNumber = 5;
        missingNumber = findMissingInt (new int[]  {0, 1, 2, 3, 4, 6});
        verifyMissingInt (missingNumber, expectedNumber);
        
        expectedNumber = 1;
        missingNumber = findMissingInt (new int[] {0});
        verifyMissingInt (missingNumber, expectedNumber);

    }

    public static void  verifyMissingInt (int actual, int expected) {
        if ( expected == actual){
            System.out.printf("The missing number %d is found \n" ,actual );
            
        } else {
            System.out.printf("The expected number is %d, the actual number is %d \n",expected ,actual);
        }      
    }

    public static int findMissingInt (int [] array) {
        int n = array.length;
        int sumn = 0; //sum of the numbers from 0 to n+1
        int sumArray = 0; // sum of the numbers in the array
        for ( int i = 0; i < n; i++){
            sumn += i;
            sumArray += array[i];
        }
        sumn += n;
        return sumn - sumArray;
    }
    public static void testSecondMaxValue() {
        int secondMax;
        int expectedNumber = 7;
        secondMax = secondMaxValue (new int[] {6, 9, 4, 7, 3, 4});
        verifySecondMaxValue (secondMax, expectedNumber);

        expectedNumber = 4;
        secondMax = secondMaxValue (new int[]  {1, 2, 3, 4, 5});
        verifySecondMaxValue (secondMax, expectedNumber);
        
        expectedNumber = 8;
        secondMax = secondMaxValue (new int[] {2, 8, 3, 7, 8});
        verifySecondMaxValue (secondMax, expectedNumber);
    }

    public static void verifySecondMaxValue (int actual, int expected) {
        if ( expected == actual){
            System.out.printf("The second maximum number is %d  \n" ,actual );
            
        } else {
            System.out.printf("The expected number is %d, the actual number is %d \n",expected ,actual);
        }      
    }

    public static int secondMaxValue(int [] array) {
        int max = Integer. MIN_VALUE;
        int secondMax = Integer. MIN_VALUE;
        int countmax = 0;
        for (int i = 0; i < array.length; i++ ){
            if (array[i] > max) {
              max = array[i];  
              countmax = 1;
            } else if (array[i] == max) {
                countmax++;
            }     
        }

        if (countmax > 1){
            return max;
        }
        for (int i = 0; i < array.length; i++ ){                
                 if (array[i] != max){
                secondMax = array[i] > secondMax ? array[i] : secondMax;
                }
            }
        
        return secondMax;
    }

    public static void testContainsTheSameElements() {
        boolean containsTheSameElements;
        boolean expectedNumber = true;
        containsTheSameElements = containsTheSameElements (new int[] {1, 2, 1, 1, 2}, new int[] {2, 1});
        verifyContainsTheSameElements (containsTheSameElements, expectedNumber);

        expectedNumber = true;
        containsTheSameElements = containsTheSameElements (new int[]  {1, 2, 3}, new int[] {1, 2, 3});
        verifyContainsTheSameElements (containsTheSameElements, expectedNumber);
        
        expectedNumber = false;
        containsTheSameElements = containsTheSameElements (new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5});
        verifyContainsTheSameElements (containsTheSameElements, expectedNumber);
    }

    public static void verifyContainsTheSameElements (boolean actual, boolean expected) {
        if ( (expected == true) && (actual == true)){
            System.out.print("The two arrays contain the same elemants  \n" );
            
        } else if((expected == false) && (actual == false)){
            System.out.print("The two arrays dont cantain the same elemants");
        } else {
            System.out.printf("The expected answer is %b, the actual answer is %b \n",expected ,actual);
        }     
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int array1Count = 0;       //  Counts how many times array1[i] == array2[j]
        int array2Count = 0;       //  Counts how many times array1[j] == array2[i]
        for (int i = 0; i < array1.length; i++){
            array1Count = 0;
            for ( int j = 0; j < array2.length; j++){
                if (array1[i] == array2[j]){
                    array1Count++;
                }              
            }
            if (array1Count == 0){       //if the count == 0 it means that array1 doesnt contain the integer at index j that belongs to array2 
                    return false;            
            }
        }

        for ( int i = 0; i < array2.length; i++){
            array2Count = 0;
            for ( int j = 0; j < array1.length; j++){
                if (array1[j] == array2[i]){
                    array2Count++;
                } 
            } 
            if (array2Count == 0){      //if the count == 0 it means that array2 doesnt contain the integer at index j that belongs to array1 
                    return false;
                }  
        }        
        return true;
    }
    
    public static void testIsSorted() {
        boolean isSorted;
        boolean expectedNumber = true;
        isSorted = isSorted (new int[] {7, 5, 4, 3, -12});
        verifyIsSorted (isSorted, expectedNumber);

        expectedNumber = true;
        isSorted = isSorted (new int[]   {1, 2, 3});
        verifyIsSorted (isSorted, expectedNumber);
        
        expectedNumber = false;
        isSorted = isSorted (new int[] {1, -2, 3});
        verifyIsSorted (isSorted, expectedNumber);
    }

    public static void verifyIsSorted (boolean actual, boolean expected) {
        if ( (expected == true) && (actual == true)){
            System.out.print("The arrey is sorted \n" );
            
        } else if((expected == false) && (actual == false)){
            System.out.print("The array isnt sorted \n");
        } else {
            System.out.printf("The expected answer is %b, the actual answer is %b \n",expected ,actual);
        }     
    }

    public static boolean isSorted(int [] array) {
        int countSortedUp = 0;
        int countSortedDown = 0;
        for (int i = 0; i < array.length - 1; i++){
            if ( array[i] < array[i + 1]){
                countSortedUp++;
            }
            if ( array[i] > array[i + 1]){
                countSortedDown++;
        }
    }
        if( (countSortedUp == array.length - 1) || (countSortedDown == array.length - 1)){
            return true;
        }

        return false;
    }

}
