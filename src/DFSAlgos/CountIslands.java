/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSAlgos;

/**
 *
 * @author ahmet
 */
public class CountIslands {
    
    //    Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. 
    
    //    Input : mat[][] = {{1, 1, 0, 0, 0},
    //                                   {0, 1, 0, 0, 1},
    //                                   {1, 0, 0, 1, 1},
    //                                   {0, 0, 0, 0, 0},
    //                                   {1, 0, 1, 0, 1} 
    //Output : 5
    
    public CountIslands()
    {
        int[][] matrix = {{1, 1, 0, 0, 0},
                          {0, 1, 0, 0, 1},
                          {1, 0, 0, 1, 1},
                          {0, 0, 0, 0, 0},
                          {1, 0, 1, 0, 1}
                         };
        
        System.out.println("Number Of Islands = " + numberOfIslands(matrix));
    }
    
    
    public int numberOfIslands(int[][] matrix)
    {
        int result = 0;
        for(int y = 0; y < matrix.length;y++)
        {
            for(int x = 0; x < matrix[0].length;x++)
            {
                if(matrix[y][x] == 1)
                {
                    result++;
                    DFS(matrix, y, x);
                }
            }
        }
        
        return result;
    }
    
    //For practice purposes I will pick DFS not BFS.
    private void DFS(int[][] matrix, int y, int x)
    {
        matrix[y][x] = -1;
       
        if(y + 1 < matrix.length && matrix[y + 1][x] == 1)DFS(matrix, y + 1,x);
        if(y - 1 >= 0 && matrix[y - 1][x] == 1)DFS(matrix, y - 1,x);
        if(x + 1 < matrix[0].length - 1 && matrix[y][x + 1] == 1)DFS(matrix, y, x + 1);
        if(x - 1 >= 0 && matrix[y][x - 1] == 1)DFS(matrix, y, x - 1);       
    }
    
    
    
}
