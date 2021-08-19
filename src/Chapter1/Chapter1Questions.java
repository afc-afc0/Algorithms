/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1;

import java.util.HashMap;

/**
 *
 * @author ahmet
 */
public class Chapter1Questions {
    
    //1.2
    //given two strings, write a method to decide if one is permutation of the other
    //Input = "abaa" , "aaab"
    
    public static boolean isPermutation(String first, String second)
    {
        if(first.length() != second.length())
            return false;

        int[] freqs = new int[256];//Extended ascii
        
        for(char ch : first.toCharArray())
            freqs[ch]++;
        
        for(char ch : second.toCharArray())
        {
            freqs[ch]--;
            if(freqs[ch] < 0)
                return false;
        }
        
        return true;
    }

    //1.3
    //URLify : Write a method to replace all spaces in a string with '%20: You may assume that the string
    //has sufficient space at the end to hold the additional characters, and that you are given the "true"
    //length of the string. (Note: If implementing in Java, please use a character array so that you can
    //perform this operation in place.)
    //

    //Input: "Mr John Smith ", 13
    //Output: "Mr%20John%20Smith"
    
    //we need to find the space count if we want to do this in place
    //then starting from end we will loop through and initilize the result. We start from last just because we dont want to overwrite.
    public static void URLify(char[] arr, int trueLength)//true size of the string
    {
        
        int spaceCount = 0;
        for(int i = 0;i < trueLength;i++)
            if(arr[i] == ' ')
                spaceCount++;
        
        int index = trueLength + 2 * spaceCount;
        if(trueLength < arr.length)arr[trueLength] = '\0';////there is a possiblity that array is bigger
        index--;
        for(int i = trueLength - 1; i >= 0;i--)
        {
            if(arr[i]== ' ')
            {
                arr[index--] = '0';
                arr[index--] = '2';
                arr[index--] = '%';
            }
            else 
                arr[index--] = arr[i];
        }
    }
    
    
    
}
