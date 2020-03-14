package com.automation.tests.day8;

public class Unit_Test_Practice {

    public static void main(String[] args) {

        // Unit test: to check if our method works properly должным образом
        // If assertion fails, that means our method doesn't work correctly,
        // that means we have to fix the method
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);

        // Assertion:  Утверждение:
        verifyEquals(expected,actual);

    //    System.out.println(reverseString("apple"));
    }


    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("test passed");
            return true;

        }else{
            System.out.println("test failed");
            System.out.println("Expected = " + expected);
            System.out.println("Actual = " + actual);
            return false;
        }
    }



    /**
     * This method stands for reversing strings
     * @param str to reverse
     * @return reversed string
     */

    public static String reverseString(String str){

        String reversed = "";
        for (int i = str.length()-1; i >=0 ; i--) {

            reversed += str.charAt(i);

        }
        return reversed;
    }

}
