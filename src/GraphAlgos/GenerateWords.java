/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ahmet
 */
public class GenerateWords {
    
    //  Generating the path (x + 1, y), (x + 1, y - 1) , (x , y - 1), (x - 1, y - 1),(x - 1, y) ,(x-1, y + 1),(x, y + 1), (x + 1, y + 1)
    private int[][] directions;
    private char[][] board;
    
    public GenerateWords()
    {
        initDirections();
        initInput();
    }
    
    private void initInput()
    {
        board = new char[4][4];
        
        board[0][0] = 'M';
        board[0][1] = 'S';
        board[0][2] = 'E';
        board[0][3] = 'F';
        
        board[1][0] = 'R';
        board[1][1] = 'A';
        board[1][2] = 'T';
        board[1][3] = 'D';
        
        board[2][0] = 'L';
        board[2][1] = 'O';
        board[2][2] = 'N';
        board[2][3] = 'E';
        
        board[3][0] = 'K';
        board[3][1] = 'A';
        board[3][2] = 'F';
        board[3][3] = 'B';
        
        HashSet<String> words = new HashSet();
        words.add("START");
        words.add("NOTE");
        words.add("SAND");
        words.add("STONED");
        
        ArrayList<String> result = generatePossibleWords(board, words);
                
        for(int i = 0; i < result.size();i++)
        {
            System.out.println("Find = " + result.get(i));
        }
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
    
    public ArrayList<String> generatePossibleWords(char[][] board, HashSet<String> words)
    {
        ArrayList<String> result = new ArrayList();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        
        for(int i = 0; i < board.length;i++)
        {
            for(int j = 0; j < board[0].length;j++)
            {
                DFS(board, visited, result, words ,i, j, "");
            }
        }
        
        return result;
    }
    
    private boolean isValid(int y, int x, boolean[][] visited)
    {
        if(y >= visited.length || y < 0 || x < 0 || x >= visited[0].length)
            return false;
        
        return  visited[y][x] ? false : true;
    }
    
    private void DFS(char[][] board, boolean[][] visited , ArrayList<String> result, HashSet<String> words , int y, int x, String path)
    {
        visited[y][x] = true;
                
        path += board[y][x];

        if(words.contains(path))
            result.add(path);
        
        for(int i = 0;i < directions.length;i++)
        {
            if(isValid(y + directions[i][0], x + directions[i][1], visited))
                DFS(board, visited, result, words, y + directions[i][0], x + directions[i][1], path);
        }
        
        visited[y][x] = false;
    }
    
}
