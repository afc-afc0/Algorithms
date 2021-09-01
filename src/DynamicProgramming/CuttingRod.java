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
public class CuttingRod {
 
    int[] prices;
    
    public CuttingRod()
    {
        prices = new int[]{1,5,8,9,10,17,17,20};
        System.out.println(getMaxPrice(4));
    }
    
    
    public int getMaxPrice(int rodLength)
    {
        int[] dp = new int[rodLength];
        dp[0] = prices[0];
        
        for(int i = 1; i < rodLength;i++)
        {
            dp[i] = prices[i];
            int left = 0;
            int right = i - 1;
            while(left <= right)
            {
                dp[i] = Math.max(dp[i], dp[left] + dp[right]);
                left++;
                right--;
            }
        }
        
        return dp[rodLength - 1];
    }
    
}
