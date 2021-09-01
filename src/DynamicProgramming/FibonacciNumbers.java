/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author ahmet
 */
public class FibonacciNumbers {
    
    
    // 1 1 2 3 5 8
    
    public static int findNthFibo(int find)
    {
        int[] dp = new int[find];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < find;i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[find - 1];
    }
    
    
}
