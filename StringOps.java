import java.util.Arrays;

public class StringOps {
    
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        testCapVowelsLowRest();
        //testcamelCase();
        //testallIndexOf();
        

    }
    public static void testCapVowelsLowRest() {
        String expecteString = "vOwEls ArE fUn";
        String capVowlesLowRest;
        capVowlesLowRest = capVowelsLowRest("vowels are fun");
        varifyCapVowelsLowRest(expecteString, capVowlesLowRest);

    }
    public static void varifyCapVowelsLowRest (String expected, String actual) {
            System.out.printf("The new string is %s \n",actual);      
    }
    
    public static String capVowelsLowRest (String string) {
        String str = "";
         for ( int i = 0; i < string.length(); i++){
            switch (string.charAt(i)) {
                case 'a':
                case 'o':
                case 'i':
                case 'u':
                case 'e':
                    str =  str + (char)(string.charAt(i) - 32);                   
                    break;
                case 'A':
                case 'O':
                case 'I':
                case 'E':
                case 'U':
                    str = str + (string.charAt(i));
                    break;                    
                default:
                    if (string.charAt(i) > 'A' && string.charAt(i) < 'Z') {
                        str = str + (char)(string.charAt(i) + 32);
                    } else {
                        str = str + (string.charAt(i));
                    }                                       
            }
         }
         return str;
    }
    public static void testcamelCase() {
        String expecteString = "helloWorld";
        String camelcase;
        camelcase = camelCase("Hello World");
        varifycamelCase(expecteString, camelcase);
        expecteString = "helloWorld";
        camelcase = camelCase("HELLO    world");
        varifycamelCase(expecteString, camelcase);
        expecteString = "introToComputerScience";
        camelcase = camelCase("Intro to coMPUter sCIEncE");
        varifycamelCase(expecteString, camelcase);

    }
    public static void varifycamelCase (String expected, String actual) {
            System.out.printf("The new string is %s \n",actual);      
    }
    public static String camelCase (String string) {
        String str = "";
        boolean isLastSpace = true;
        int isFoundFirstWord = 0;
        char ch = ' ';
        for(int i = 0; i< string.length(); i++){
            if(string.charAt(i) == ' '){
                isLastSpace = true;
            } else {
                //processing the characters but spaces
                if (isLastSpace == true) {
                    ///begining of word
                    isLastSpace = false;
                    // convert char to uppercase

                    switch (isFoundFirstWord){
                        case 0:
                            ch = convertLowerCase(string.charAt(i));
                            isFoundFirstWord = 1;
                        break;
                        case 1:
                            ch = convertUpperCase(string.charAt(i));
                        break;
                    }                    
                } else {
                    // convert char to lowcase
                    ch = convertLowerCase(string.charAt(i));
                }
                //add char to str
                str = str + ch;
            }                
        }    
        return str;
    }
    
    public static Boolean isUpperCase (char ch){
           return (ch >= 'A'&& ch <= 'Z' );       
    }

    public static char convertUpperCase( char ch) {
        if(isUpperCase(ch) == false){
            return (char)(ch - 32);
        } else {
            return ch;
        }
    }

    public static char convertLowerCase( char ch) {
        if(isUpperCase(ch) == true){
            return (char)(ch + 32);
        } else {
            return ch;
        }
    }
    public static void testallIndexOf() {
        int expected [] = {2, 3, 9};
        char characterToFind = 'l';
        int[] allIndexOf = allIndexOf("Hello world",characterToFind);
        varifyAllIndexOf(expected, allIndexOf);
       

    }
    public static void varifyAllIndexOf (int[] expected, int[] actual) {
            System.out.printf("The new array is %s \n",Arrays.toString(actual));  
    }
    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        int arr[];
        int index = 0;
        for(int i = 0; i < string.length(); i++){
           if(string.charAt(i) == chr){
            count++;
           }
        }
        arr = new int[count];
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == chr){
                arr[index] = i;
                index++;
            }
        }
        return  arr;
    }
}
