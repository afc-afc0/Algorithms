/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityFunctions;

/**
 *
 * @author ahmet
 */
public class UtilityFunctions {
    
    public static void PrintMatrix(char[][] matrix)
    {
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j = 0; j < matrix[0].length;j++)
               System.out.print(matrix[i][j] + "-");
            
            System.out.println();
        }
    }
}
