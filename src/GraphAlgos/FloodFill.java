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
public class FloodFill {
    
    char[][] graph = {
                "YYYGGGGGGG".toCharArray(),
                "YYYYYYGXXX".toCharArray(),
                "GGGGGGGXXX".toCharArray(),
                "WWWWWGGGGX".toCharArray(),
                "WRRRRRGXXX".toCharArray(),
                "WWWRRGGXXX".toCharArray(),
                "WBWRRRRRRX".toCharArray(),
                "WBBBBRRXXX".toCharArray(),
                "WBBXBBBBXX".toCharArray(),
                "WBBXXXXXXX".toCharArray()
    };
    
    int[] yDir = new int[]{1, 1, 1, 0, 0, 0,-1,-1,-1};
    int[] xDir = new int[]{1, 0,-1, 1, 0,-1, 1, 0,-1};
    int ySize, xSize;
    
    public FloodFill()
    {
        ySize = graph.length;
        xSize = graph[0].length;
        System.out.println("Before");
        print();
        
        replace(1, 9, 'A');
        
        System.out.println("After");
        print();
    }
    
    private void replace(int y, int x, char replacement){
        
        char replace = graph[y][x];
        
        for(int i = 0; i < ySize;i++)
        {
            for(int j = 0; j < xSize;j++)
            {
                DFS(i, j, replace, replacement);
            }
        }
        
    }
    
    private void DFS(int y, int x, char currentChar, char replacement) {
        
        if(!isValid(y,x, currentChar))
            return;
        
        graph[y][x] = replacement;
        
        for(int i = 0; i < 8;i++)
            DFS(y + yDir[i], x + xDir[i], currentChar, replacement);
    }
    
    private void print()
    {
        for(int y = 0; y < ySize;y++)
        {
            for(int x = 0; x < xSize;x++)
                System.out.print(graph[y][x]);
            
            System.out.println();
        }
    }

    private boolean isValid(int y, int x, char currentChar) {
        
        if(y < 0 || y >= ySize || x < 0 || x >= xSize)
            return false;
        
        if(graph[y][x] != currentChar)
            return false;
        
        return true; 
    }
    
    
    
    
    
}
