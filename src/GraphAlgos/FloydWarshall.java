/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

/**
 *
 * @author ahmet
 */
public class FloydWarshall {
    
    //Given adjecency matrix
    public static int[][] findAPSP(int[][] adjecencyMatrix)
    {
        int[][] matrix = adjecencyMatrix.clone();
                
        for(int i = 0; i < matrix.length;i++)
        {
            for(int y = 0; y < matrix.length;y++)
            {   
                for(int x = 0;x < matrix.length;x++)
                {
                    if(matrix[y][i] == Integer.MAX_VALUE || matrix[i][x] == Integer.MAX_VALUE)
                        continue;
                    
                    matrix[y][x] = Math.min(matrix[y][x], matrix[y][i] + matrix[i][x]);
                }
            }
        }
        
        return matrix;
    }
    
    
    
}
