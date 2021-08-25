/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSAlgos;

import java.util.ArrayList;

/**
 *
 * @author ahmet
 */
public class TransitiveClosureMatrix {
    
    //    Given a directed graph, find out if a vertex v is reachable from another
    //    vertex u for all vertex pairs (u, v) in the given graph.
    //    Here reachable means that there is a path from vertex u to v. 
    //    The reach-ability matrix is called transitive closure of a graph.
    
    ArrayList<Integer>[] adjecencyList;
    int size = -1;
    
    public TransitiveClosureMatrix()
    {
        buildAdjecencyMatrix();
        int[][] closureMatrix = getClosureMatrix();
        printMatrix(closureMatrix);
    }
    
    private void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j = 0; j < matrix[0].length;j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void buildAdjecencyMatrix()
    {
        size = 4;
        adjecencyList = new ArrayList[size];
        for(int i = 0; i < size;i++)
            adjecencyList[i] = new ArrayList();
        
        initAdjecencyList();
    }
    
    private void initAdjecencyList()
    {
        ArrayList<Integer> node0 = new ArrayList();
        node0.add(1);
        node0.add(2);
        
        ArrayList<Integer> node1 = new ArrayList();
        node1.add(2);
        
        ArrayList<Integer> node2 = new ArrayList();
        node2.add(3);
        node2.add(0);
        
        ArrayList<Integer> node3 = new ArrayList();
        
        adjecencyList[0] = node0;
        adjecencyList[1] = node1;
        adjecencyList[2] = node2;
        adjecencyList[3] = node3;
    }
    
    public int[][] getClosureMatrix()
    {
        int[][] closureMatrix = new int[adjecencyList.length][adjecencyList.length];
        
        for(int i = 0; i < size;i++)
        {
            DFS(adjecencyList[i], i, i, closureMatrix);
        }
        
        return closureMatrix;
    }
    
    public void DFS(ArrayList<Integer> edges, int nodeIndex, int targetIndex, int[][] closureMatrix)
    {
        if(closureMatrix[nodeIndex][targetIndex] == 1)
            return;
        
        closureMatrix[nodeIndex][targetIndex] = 1;
        for(int target : edges)
        {
            DFS(adjecencyList[target], nodeIndex, target, closureMatrix);
        }
    }
    
    
}
