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
public class RouteBetweenNodes {
    
    ArrayList<ArrayList<Integer>> graph;
    
    public RouteBetweenNodes()
    {
        graph = new ArrayList();
        buildGraph();
    }
  
    public void buildGraph()
    {
        ArrayList<Integer> node0 = new ArrayList();
        node0.add(1);
        
        ArrayList<Integer> node1 = new ArrayList();
        node1.add(2);
        
        ArrayList<Integer> node2 = new ArrayList();
        node2.add(3);
        node2.add(4);
        node2.add(5);

        ArrayList<Integer> node3 = new ArrayList();

        ArrayList<Integer> node4 = new ArrayList();
        node4.add(6);

        ArrayList<Integer> node5 = new ArrayList();

        ArrayList<Integer> node6 = new ArrayList();

        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
        graph.add(node6);
        
        System.out.println(isConnected(0, 5));
    }
    
    public boolean isConnected(int source, int target)
    {
        boolean[] visited = new boolean[graph.size()];
        
        return DFS(source, target, visited);
    }
    
    public boolean DFS(int currentNodeIndex, int target, boolean[] visited)
    {   
        if(visited[currentNodeIndex])
            return false;
     
        if(currentNodeIndex == target)
            return true;
        
        visited[currentNodeIndex] = true;
        
        ArrayList<Integer> adjList = graph.get(currentNodeIndex);

        for(int node : adjList)
        {
            if(!visited[node])
                if(DFS(node, target, visited)) {
                    return true;
                }
        }

        return false;
    }
}
