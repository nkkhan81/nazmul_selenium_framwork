package com.naz.classTest;

import org.testng.annotations.Test;

/**
 * Created by nkkhan on 2/3/18.
 */
public class Test1_ReverseString {

    public static void reverseEverything(String s){
        char[] givenString = new char[s.length()];
        givenString = s.toCharArray();
        String reverseString = "";
        for (int i=(s.length()-1); i>=0; i--){
            reverseString = reverseString+givenString[i];
        }
        System.out.println(reverseString.toLowerCase());
    }

    @Test
    public void verifyReverseString(){
        reverseEverything("Good Morning");
    }
}
