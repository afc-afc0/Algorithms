package DynamicProgramming;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class LongestCommonSubsequence
{

    // X: ABCBDAB
    // Y: BDCABA
    // The length of the LCS is 4
    // LCS are BDAB, BCAB, and BCBA
    
    String str1;
    String str2;
    public LongestCommonSubsequence() 
    {
        str1 = "ABCBDAB";
        str2 = "BDCABA";
        System.out.println(lcs(str1, str2));
    }    

    private int lcs (String str1, String str2)
    {
        return helper(str1, str2, str1.length() - 1, str2.length() - 1, new HashMap<>());
    }

    private int helper (String str1, String str2, int index1, int index2, HashMap<int[], Integer> memo)
    {
        if (!isValid(index1, index2))
            return 0;

        int[] key = new int[]{index1, index2};
        if (memo.containsKey(key))
            return memo.get(key);
        

        int result = 0;
        if (str1.charAt(index1) == str2.charAt(index2)) // last character are same
        {
            result = 1 + helper (str1, str2, index1 - 1, index2 - 1, memo);
        }
        else // not same
        {
            result = Math.max( helper(str1, str2, index1 - 1, index2, memo) , helper(str1, str2, index1, index2 - 1, memo));
        }
        memo.put(key, result);

        return result;
    }

    private boolean isValid (int index1, int index2)
    {
        if (index1 < 0 || index2 < 0)
            return false;

        return true;
    }
}





