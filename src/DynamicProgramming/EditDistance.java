package DynamicProgramming;

public class EditDistance {
    

    private String str1;
    private String str2;

    public EditDistance() {

        str1 = "sitting";
        str2 = "kitten";

        System.out.println("Edit Distance of str1 : " + str1 + " , str2 : " + str2 + " ----> Distance = " + editDistance(str1, str2));
    }

    // str1 = "AFC"  str2 = "ZFCK"
    
    
    // With Brute Force : How ?

    // Case 1 : if any of the strings are empty we need to insert the elements in other str
    // str1 = "" --- str2 = "AFC" 
    // str1 = "AFC" inserted 3 elements

    // Case 2 : last characters are same
    // We can decrease the size of 2 strings
    // str1 = "AFC" --- str2 = "ZBC" 
    // ---> We can just remove the last char and calculate the rest which is "AF" -- "ZB"

    // Case 3 : last characters arent the same
    // Basically we have 3 choices to make 
    // 1) Delete Char
    // 2) Insert Char
    // 3) Replace Char

    // Brute Force solution will have O(3^m) because in the worse case we have a 3 possible choices we can make
    // str1 = "ABC"  str2 = "DFK" 

    private int editDistance (String str1, String str2)
    {
        
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for (int row = 0; row < dp.length; row++) {
            dp[row][0] = row; 
        }

        for (int column = 0; column < dp[0].length; column++) {
            dp[0][column] = column;
        }

        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++) 
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = 1 + min3(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[str1.length()][str2.length()];
    }

    private int min3 (int x, int y, int z)
    {
        return x < y ? (x < z ? x : (z < y ? z : y)) : (y < z ? y : (z < x ? z : x)); 
    }


}
