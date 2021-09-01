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

//Find all occurrences of the given string in a character matrix

// [ D  E  M  X  B ]
// [ A  O  E  P  E ]
// [ D  D  C  O  D ]    //CODE
// [ E  B  E  D  S ]
// [ C  P  Y  E  N ]

//Output 

//C(2, 2)   O(1, 1)   D(0, 0)   E(0, 1)
//C(2, 2)   O(1, 1)   D(2, 0)   E(3, 0)
//C(2, 2)   O(1, 1)   D(2, 1)   E(1, 2)
//C(2, 2)   O(1, 1)   D(2, 1)   E(3, 0)
//C(2, 2)   O(1, 1)   D(2, 1)   E(3, 2)
//C(2, 2)   O(2, 3)   D(2, 4)   E(1, 4)
//C(2, 2)   O(2, 3)   D(3, 3)   E(3, 2)
//C(2, 2)   O(2, 3)   D(3, 3)   E(4, 3)

public class FindOccurrencesOfStringInMatrix {
    
    char[][] graph;
    int ySize;
    int xSize;
    int[] yDir = new int[]{1, 1, 1, 0, 0, 0,-1,-1,-1};
    int[] xDir = new int[]{1, 0,-1, 1, 0,-1, 1, 0,-1};
    
    public FindOccurrencesOfStringInMatrix()
    {
        initGraph();
    }
    
  
    
    private void initGraph()
    {
        ySize = 5;
        xSize = 5;
        
        graph = new char[ySize][xSize];
        
        graph[0][0] = 'D';
        graph[0][1] = 'E';
        graph[0][2] = 'M';
        graph[0][3] = 'X';
        graph[0][4] = 'B';
        
        graph[1][0] = 'A';
        graph[1][1] = 'O';
        graph[1][2] = 'E';
        graph[1][3] = 'P';
        graph[1][4] = 'E';
        
        graph[2][0] = 'D';
        graph[2][1] = 'D';
        graph[2][2] = 'C';
        graph[2][3] = 'O';
        graph[2][4] = 'D';
        
        graph[3][0] = 'E';
        graph[3][1] = 'B';
        graph[3][2] = 'E';
        graph[3][3] = 'D';
        graph[3][4] = 'S';
        
        graph[4][0] = 'C';
        graph[4][1] = 'P';
        graph[4][2] = 'Y';
        graph[4][3] = 'E';
        graph[4][4] = 'N';
        
        ArrayList<String> res = findOccurrences("CODE");
        for(String str : res)
            System.out.println(str);
    }
    
    
    // [ D  E  M  X  B ]
    // [ A  O  E  P  E ]
    // [ D  D  C  O  D ]    //CODE
    // [ E  B  E  D  S ]
    // [ C  P  Y  E  N ]
    
   
    
    private ArrayList<String> findOccurrences(String word)
    {
        ArrayList<String> result = new ArrayList<>();
        
        boolean[][] visited = new boolean[ySize][xSize];
        
        for(int y = 0; y < ySize;y++)
        {
            for(int x = 0; x < xSize;x++)
            {
                DFS(y, x, result, new StringBuilder(), word, 0);
            }
        }
        
        return result;
    }
    
    //C(2, 2)   O(1, 1)   D(0, 0)   E(0, 1)
    //C(2, 2)   O(1, 1)   D(2, 0)   E(3, 0)
    //C(2, 2)   O(1, 1)   D(2, 1)   E(1, 2)
    //C(2, 2)   O(1, 1)   D(2, 1)   E(3, 0)
    //C(2, 2)   O(1, 1)   D(2, 1)   E(3, 2)
    //C(2, 2)   O(2, 3)   D(2, 4)   E(1, 4)
    //C(2, 2)   O(2, 3)   D(3, 3)   E(3, 2)
    //C(2, 2)   O(2, 3)   D(3, 3)   E(4, 3)
    
    private void DFS(int y, int x, ArrayList<String> result, StringBuilder path, String word, int wordIndex)
    {
        if(!isValid(y,x))
            return;
        
        if(word.charAt(wordIndex) !=  graph[y][x])
            return;
        
        path.append(graph[y][x]).append("(").append(y).append(",").append(x).append(")").append(" ");
        
        if(wordIndex == word.length() - 1)
        {
            result.add(path.toString());
            path.delete(path.length() - 7, path.length());
            return;
        }
        
        for(int i = 0; i < yDir.length;i++)
            DFS(y + yDir[i], x + xDir[i], result, path, word, wordIndex + 1);
        
        
        path.delete(path.length() - 7, path.length());
    }
    
    private boolean isValid(int y, int x) {
        
        if(y < 0 || y >= ySize || x < 0 || x >= xSize)
            return false;
        
        return true; 
    }
    
}
