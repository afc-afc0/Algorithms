/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;

/**
 *
 * @author ahmet
 */
public class FindTheLengthOfTheLongestPathWithConsecutiveCharacters {
    
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private char[][] graph;
    private int ySize, xSize;
    private int[][] directions;

    public FindTheLengthOfTheLongestPathWithConsecutiveCharacters()
    {
        initDirections();
        initGraph();
    }
    
    private void initGraph()
    {
        ySize = 5;
        xSize = 5;
        graph = new char[ySize][xSize];
        
        graph[0][0] = 'D';
        graph[0][1] = 'E';
        graph[0][2] = 'H';
        graph[0][3] = 'X';
        graph[0][4] = 'B';
        
        graph[1][0] = 'A';
        graph[1][1] = 'O';
        graph[1][2] = 'G';
        graph[1][3] = 'P';
        graph[1][4] = 'E';
        
        graph[2][0] = 'D';
        graph[2][1] = 'D';
        graph[2][2] = 'C';
        graph[2][3] = 'F';
        graph[2][4] = 'D';
        
        graph[3][0] = 'E';
        graph[3][1] = 'B';
        graph[3][2] = 'E';
        graph[3][3] = 'A';
        graph[3][4] = 'S';
        
        graph[4][0] = 'C';
        graph[4][1] = 'D';
        graph[4][2] = 'Y';
        graph[4][3] = 'E';
        graph[4][4] = 'N';
        
        System.out.println("Longest consecutive = " + maxLenOfConsecutiveWord('C'));
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
    
    int result = 1;
    private int maxLenOfConsecutiveWord(char ch)
    {
        if(graph.length == 0)
            return 0;
        
        result = 1;
        boolean[][] visited = new boolean[ySize][xSize];
        
        for(int y = 0; y < ySize;y++)
        {
            for(int x = 0; x < xSize;x++)
            {
                if(ch == graph[y][x])
                    DFS(y, x, visited, "");
            }
        }
        
        return result;
    }

    private void DFS(int y, int x, boolean[][] visited, String path) 
    {
        if(!isValid(y, x, path, visited))
            return;
            
        visited[y][x] = true; 
        path += graph[y][x];
        
        if(path.length() > result)
            result = path.length();
        
        
        for(int[] direction : directions)
        {
            DFS(y + direction[0], x + direction[1], visited, path); 
        }
        
        visited[y][x] = false;
        
    }

    private boolean isValid(int y, int x, String path, boolean[][] visited) {
        
        if(y < 0 || y >= ySize || x < 0 || x >= xSize)
            return false;

        if(path.length() != 0 && path.charAt(path.length() - 1) == 'Z')
            return false;
        
        if(visited[y][x])
            return false;
        
        if(path.length() == 0)
            return true;
        
        int key = path.charAt(path.length() - 1) - 'A' + 1;
        if(graph[y][x] != alphabet.charAt(key))
            return false;
        
        return true; 
    }
    
    
    
}
