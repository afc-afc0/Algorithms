/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterview;

import static Chapter1.Chapter1Questions.isPermutation;
import static Chapter1.Chapter1Questions.URLify;

/**
 *
 * @author ahmet
 */
public class CrackingTheCodingInterview {

    public static void main(String[] args) {
        char[] arr = new char[30];
        String str = "x";
        char[] strCharArray = str.toCharArray();
        for(int i = 0;i < strCharArray.length;i++)
            arr[i] = strCharArray[i];
              
        URLify(arr,1);
        printCharArray(arr);
    }
    
    static void printCharArray(char[] arr)
    {
        for(int i = 0; i < arr.length;i++)
            System.out.print(arr[i]);
    }
    
}
