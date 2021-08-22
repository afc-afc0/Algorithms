/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author ahmet
 */
public class Graph {
    
    public ArrayList<Node> nodes;
    public PriorityQueue<Node> pq;

    public Graph()
    {
        nodes = new ArrayList();
        pq = new PriorityQueue();
    }
    
    public void dijkstra(Node startNode)
    {
        startNode.weight = 0;
        pq.offer(startNode);
        HashSet<Node> visited = new HashSet();
        
        while(!pq.isEmpty())
        {
            Node n = pq.poll();
            
            for(Edge edge : n.edges)
            {
                Node target = edge.target;
                
                if(target.weight > n.weight + edge.weight)
                    target.weight = n.weight + edge.weight;
                
                if(!visited.contains(target))
                {
                    pq.offer(target);
                    visited.add(target);
                }
            }
        }
    }
 
    public void printPriorityQueue()
    {
        for(int i = 0; i < pq.size(); i++)
        {
            System.out.println(nodes.get(i).weight);
        }
    }
    
    public void printNodes()
    {
        for(int i = 0; i < nodes.size(); i++)
        {
            System.out.println(nodes.get(i).weight);
        }
    }
}
