package com.naz.classTest;

import org.testng.annotations.Test;

/**
 * Created by nkkhan on 2/3/18.
 */
public class Test1_ReverseString {

    public static void reverseEverything(String string){
        char[] givenString = new char[string.length()];
        givenString = string.toCharArray();
        String reverseString = "";
        for (int i=(string.length()-1); i>=0; i--){
            reverseString = reverseString+givenString[i];
        }
        System.out.println(reverseString.toLowerCase());
    }

    @Test
    public void verifyReverseString(){
        reverseEverything("Good Morning");
    }
}
