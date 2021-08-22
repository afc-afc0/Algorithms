/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ahmet
 */
public class BreadthFirstSearch {
    
    public static <T> ArrayList<T> BFS(GraphNode<T> node)
    {
        if(node == null)
            return null;
        
        HashSet<GraphNode<T>> set = new HashSet();
        ArrayList<T> result = new ArrayList();
        Queue<GraphNode<T>> q = new LinkedList();
        q.offer(node);
        
        while(!q.isEmpty())
        {
            GraphNode<T> tmp = q.poll();
            set.add(tmp);
            result.add(tmp.val);
            
            for(GraphNode<T> n : tmp.neighBours)
            {
                if(set.contains(n))
                    continue;
                q.offer(n);
            }
        }
        
        return result;
    }
}
