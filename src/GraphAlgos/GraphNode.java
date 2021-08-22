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
public class GraphNode<T> {
    public T val;
    public ArrayList<GraphNode<T>> neighBours;
    
    public GraphNode(T val)
    {
        neighBours = new ArrayList();
        this.val = val;
    }
    
}
