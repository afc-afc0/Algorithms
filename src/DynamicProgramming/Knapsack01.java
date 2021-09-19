package DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {
    
    int[] values;
    int[] weights;
    int maxWeight;

    public Knapsack01() {
        values = new int[]{ 20, 5, 10, 40, 15, 25};
        weights = new int[]{1,  2, 3,  8,  7,  4};
        maxWeight = 10;
        System.out.println(knapsack(values, weights, maxWeight));
    }

    // for 10 I can select 1 2 3 8 7 4 
    // there is overlapping subproblems we are calculating over and over again 
    private int knapsack(int[] values, int[] weights, int maxWeight)
    {
        int[][] dp = new int[weights.length + 1][maxWeight + 1];

       
        for (int item = 1; item <= weights.length; item++) {
            int currentItem  = item - 1;
            for (int weight = 1; weight <= maxWeight; weight++)
            {
                if (weight - weights[currentItem] >= 0)
                {
                    dp[item][weight] = Math.max(dp[item - 1][weight - weights[currentItem]] + values[currentItem], dp[item - 1][weight]);
                }        
                else
                    dp[item][weight] = dp[item - 1][weight];
            }
        }

        return dp[values.length][maxWeight];
    }
    

}
