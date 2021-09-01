/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.Arrays;

/**
 *
 * @author ahmet
 */
public class ReplaceSurrounded0s {
    
    private int[][] graph;
    private int[][] directions;
    private int ySize, xSize;
    
    public ReplaceSurrounded0s()
    {
        initDirections();
        initGraph();
    }
    
    private void initGraph()
    {
        ySize = 5;
        xSize = 5;
        graph = new int[ySize][xSize];
        
        graph[0][0] = 0;
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[0][3] = 1;
        graph[0][4] = 1;
        
        graph[1][0] = 0;
        graph[1][1] = 1;
        graph[1][2] = 0;
        graph[1][3] = 1;
        graph[1][4] = 1;
        
        graph[2][0] = 1;
        graph[2][1] = 1;
        graph[2][2] = 0;
        graph[2][3] = 1;
        graph[2][4] = 1;
        
        graph[3][0] = 1;
        graph[3][1] = 1;
        graph[3][2] = 1;
        graph[3][3] = 1;
        graph[3][4] = 1;
        
        graph[4][0] = 1;
        graph[4][1] = 1;
        graph[4][2] = 0;
        graph[4][3] = 0;
        graph[4][4] = 0;
        
        replaceSurrounded0s();
    }
    
    private void initDirections() 
    {
        // dp[i][0] = y     , dp[i][1] = x
        directions = new int[8][2];
        
        //north
        directions[0][0] = 1; 
        directions[0][1] = 0;
        
        //north east
        directions[1][0] = 1;
        directions[1][1] = 1;
        
        //east
        directions[2][0] = 0;
        directions[2][1] = 1;
        
        //south east
        directions[3][0] = -1;
        directions[3][1] = 1;
        
        //south
        directions[4][0] = -1;
        directions[5][1] = 0;
        
        //south west
        directions[5][0] = -1;
        directions[5][1] = -1;
        
        //west
        directions[6][0] = 0;
        directions[6][1] = -1;
        
        //north west
        directions[7][0] = 1;
        directions[7][1] = -1;   
    }
    
    int[][] result;
    private void replaceSurrounded0s()
    {
        for(int y = 0; y > ySize;y++)
            result[y] = Arrays.copyOf(graph[y], xSize);
                
        boolean[][] visited = new boolean[ySize][xSize];
        
        for(int x = 0; x < xSize;x++)
        {
            if(graph[0][x] == 0)
               DFS(0, x, visited);
            
            if(graph[ySize - 1][x] == 0)
               DFS(ySize - 1, x, visited);
        }
        
        for(int y = 1; y < ySize;y++)
        {
            if(graph[y][0] == 0)
                DFS(y, 0, visited);
            
            if(graph[y][xSize - 1] == 0)
                DFS(y, xSize -1, visited);
        }

        for(int y = 0; y < ySize;y++)
            for(int x = 0; x < xSize;x++)
                if(graph[y][x] == 0)
                    graph[y][x] = 1;
       
        for(int y = 0; y < ySize;y++)
            for(int x = 0; x < xSize;x++)
                if(graph[y][x] == -1)
                    graph[y][x] = 0;
        
        print();
    }
    
    private void print()
    {
        for(int i = 0; i < ySize;i++)
        {
            for(int j = 0; j < xSize;j++)
                System.out.print(graph[i][j] + " ");
            
            System.out.println();
        }
    }
    
    private void DFS(int y, int x, boolean[][] visited)
    {
        if(!isValid(y, x, visited))
            return;
        
        visited[y][x] = true;
        graph[y][x] = -1;
        
        for(int[] dir : directions)
            DFS(y + dir[0], x + dir[1], visited);
    }

    private boolean isValid(int y, int x, boolean[][] visited) {
        
        if(y < 0 || y >= ySize || x < 0 || x >= xSize)
            return false;
        
        if(visited[y][x])
            return false;
        
        if(graph[y][x] == 1)
            return false;
        
        return true;
    }
}
