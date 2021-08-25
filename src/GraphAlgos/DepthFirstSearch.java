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
public class DepthFirstSearch {
    
    
    public static <T> ArrayList<GraphNode<T>> DFS(GraphNode<T> startNode, int N)
    {
        ArrayList<GraphNode<T>> result = new ArrayList();
        HashSet<GraphNode<T>> visited = new HashSet();
        helper(startNode ,visited, result);
        
        return result;
    }
    
    public static <T> void helper(GraphNode<T> node, HashSet<GraphNode<T>> visited, ArrayList<GraphNode<T>> result)
    {
        if(visited.contains(node))
            return;
        
        System.out.println(node.val);
        visited.add(node);
        result.add(node);
        
        for(GraphNode<T> neighbour : node.neighBours)
            helper(neighbour, visited, result);
        
        System.out.println(node.val);
    }
}
