/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author ahmet
 */
public class Edge {
    public Node source;
    public Node target;
    public int weight;
    
    public Edge(Node source, Node target, int weight)
    {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    
}
