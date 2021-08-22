/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.ArrayList;

/**
 *
 * @author ahmet
 */
public class Node implements Comparable<Node>{
    public String name;
    public int weight;
    public ArrayList<Edge> edges;
    
    public Node(String name)
    {
        edges = new ArrayList();
        weight = Integer.MAX_VALUE;
        this.name = name;
    }    
    
    //We are not checking if we have dublicated edge!!!!
    
    public void addEdge(Edge edge)
    {
        edges.add(edge);
    }
    
    public void printNeighbours()
    {
        for(int i = 0; i < edges.size();i++)
        {
            System.out.println("name = " + edges.get(i).target.name + " ,weight = " + edges.get(i).weight);
        }
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
    
}
