/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author ahmet
 */
public class TopologicalSort {
        
    
    public HashMap<Integer, ArrayList<Integer>> graph;

    public TopologicalSort()
    {
        graph = new HashMap();

        initGraph();
    }

    private void initGraph()
    {
        addEdge(0,6);
        addEdge(1,2);
        addEdge(1,4);
        addEdge(1,6);
        addEdge(3,0);
        addEdge(3,4);
        addEdge(5,1);
        addEdge(7,0);
        addEdge(7,1);   
        
        ArrayList<Integer> res = topologicalSort();
    }

    public void addEdge(int source, int target)
    {
        if(!graph.containsKey(source))
            graph.put(source, new ArrayList());

        graph.get(source).add(target);
    }

    private ArrayList<Integer> topologicalSort()
    {
        HashSet<Integer> visited = new HashSet();
        Deque<Integer> deq = new LinkedList();
        ArrayList<Integer> result = new ArrayList();
        
        for(Integer node : graph.keySet())
        {            
            DFS(node, visited, deq);
        }
        
        while(!deq.isEmpty())
        {
            System.out.print(deq.pop());
        }
        
        return result;
    }

    private void DFS(Integer node, HashSet<Integer> visited, Deque deq) {

        if(visited.contains(node))
            return;
        
        visited.add(node);
        
        ArrayList<Integer> edges = graph.get(node);
        if(edges != null)
            for(Integer edge : edges)
            {
                DFS(edge, visited, deq);
            }
        
        deq.push(node);
    }



    
    
    
    
}
