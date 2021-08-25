/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ahmet
 */
public class Eulerian {
    
    ArrayList<ArrayList<Integer>> graph;
    int[] incoming;
    int[] outgoing;
    int start, finish;
   
    
    LinkedList<Integer> path;
    
    public Eulerian(){
        buildGraph();
    }
    
    private void buildGraph(){
        graph = new ArrayList();
        
        ArrayList<Integer> node0 = new ArrayList();
        ArrayList<Integer> node1 = new ArrayList();
        ArrayList<Integer> node2 = new ArrayList();
        ArrayList<Integer> node3 = new ArrayList();
        ArrayList<Integer> node4 = new ArrayList();
        
        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        
        node0.add(1);
        node1.add(2);
        node2.add(3);
        node3.add(4);
        node4.add(0);
        
        
        initIncomingAndOutcoming();
    }

    private boolean validate()
    {
        int start = -1, finish = -1;
        for(int i = 0; i < graph.size();i++)
        {
            if(incoming[i] < outgoing[i])
            {
                if(start != -1)
                    return false;
                start = i;
            }
            else if(incoming[i] > outgoing[i])
            {
                if(finish != -1)
                    return false;
                finish = i;
            }
        }
        
        if(start == -1 && finish == -1)
            return true;
        
        if(start != -1 && finish == -1)
            return false;
        
        if(start == -1 && finish != -1)
            return false;
                 
        return true;
    }
    
    private void initIncomingAndOutcoming() {
       
        incoming = new int[graph.size()];
        outgoing = new int[graph.size()];
        
        for(int source = 0;source < graph.size();source++)
        {
            ArrayList<Integer> node = graph.get(source);
            for(int edgeIndex = 0; edgeIndex < node.size();edgeIndex++)
            {
                outgoing[source]++;
                incoming[node.get(edgeIndex)]++;
            }
        }
    }
    
    
    
    
}
