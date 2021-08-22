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
public class DepthFirstSearch {
    
    
    public <T> ArrayList<T> DFS(GraphNode<T> node)
    {
        
        
        for(GraphNode<T> n : node.neighBours)
            DFS(n);
        
        return null;
    }
}
