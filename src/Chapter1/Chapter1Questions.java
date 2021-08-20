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
    
    //Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    //A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    //is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
    //EXAMPLE
    //Input: Tact Coa
    //Output: True (permutations: "taco cat". "atco cta". etc.)
    
    public static boolean isPermutationPalindrome(String str)
    {
        HashMap<Character, Integer> map = new HashMap();//Frequencies
        
        for(char ch : str.toCharArray())
        {
            if(Character.isAlphabetic(ch))
            {
                ch = Character.toLowerCase(ch);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        
        boolean findOddCharFreq = false;
        for(char ch : map.keySet())
        {
            if(map.get(ch) % 2 == 1)
            {
                if(findOddCharFreq == false)
                    findOddCharFreq = true;
                else
                    return false;
            }
        }
        
        return true;
    }
    
    //One Away: There are three types of edits that can be performed on strings: insert a character,
    //remove a character, or replace a character. Given two strings, write a function to check if they are
    //one edit (or zero edits) away.
    //EXAMPLE
    //pale, pIe -> true       //deletetion
    //pale. pales -> true   //insertion
    //pale. bale -> true    //rep
    //pale. bake -> false
    
    public static boolean oneAway(String first, String second)
    {        
        if(first.length() == second.length() + 1)
            return oneDeleteAway(first, second);
        else if(first.length() + 1 == second.length())
            return oneDeleteAway(first, second);
        else if(first.length() == second.length())
            return oneReplaceAway(first,second);
        
        return false;
    }
    
    // pIe , pale
    private static boolean oneDeleteAway(String first, String second)//first is smaller
    {
        if(second.length() < first.length())//guarantee that get the smaller for first string
            return oneDeleteAway(second, first);
        
        int secondIndex = 0;
        boolean deleteFound = false;
        for(int i = 0; i < first.length();i++,secondIndex++)
        {
            if(first.charAt(secondIndex) == second.charAt(i))
                continue;
            
            if(deleteFound)
                return false;
            else
            {
                deleteFound = true;
                secondIndex++;
            }
        }
        
        return true;
    }
   
    //pale. bale  => true
    private static boolean oneReplaceAway(String first, String second)
    {
        boolean findDif = false;
        for(int i = 0; i < first.length();i++)
        {
            if(first.charAt(i) != second.charAt(i))
                if(findDif)
                    return false;
                else
                    findDif = true;
        }
        
        return true;
    }
    
    
    //String Compression: Implement a method to perform basic string compression using the counts
    //of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    //"compressed" string would not become smaller than the original string, your method should return
    //the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    //"aabcccccaaa" =>  "a2b1c5a3"
    //owerwrite danger if "ab" = "a1b1"  
    //  "abcsadagsdfeadfasd" =>
    public static String stringCompression(String str)
    {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for(int i = 0;i < str.length();i++)
        {
            count++;
            
            if(i == str.length() - 1|| str.charAt(i) != str.charAt(i + 1))
            {
                sb.append(str.charAt(i)).append(count);
                count = 0;
            }
        }
        
        return sb.length() < str.length() ? sb.toString() : str;
    }
    
    //Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    //column are set to 0.
    public static void setZeros(int[][] matrix)
    {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        
        for(int i = 0; i < matrix.length;i++)
            for(int j = 0;j < matrix[0].length;j++)
                if(matrix[i][j] == 0)
                {
                    rows[i] = true;
                    columns[j] = true;
                }
        
        for(int i = 0; i < rows.length;i++)
            if(rows[i])
                nullifyRow(matrix[i]);
        
        for(int i = 0;i < columns.length;i++)
            if(columns[i])
                nullifyColumn(matrix, i);
    }
    
    private static void nullifyRow(int[] row)
    {
        for(int i = 0;i < row.length;i++)
            row[i] = 0;
    }
   
    private static void nullifyColumn(int[][] matrix, int colNum)
    {
        for(int i = 0; i < matrix.length;i++)
            matrix[i][colNum] = 0;
    }
    
}
