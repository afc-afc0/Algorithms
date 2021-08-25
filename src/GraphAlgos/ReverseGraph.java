/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author ahmet
 */

//public class GraphNode<T> {
//    public T val;
//    public ArrayList<GraphNode<T>> neighBours;
//    
//    public GraphNode(T val)
//    {
//        neighBours = new ArrayList();
//        this.val = val;
//    }
//    
//}

public class ReverseGraph<T> {
 
    public GraphNode<T>[] graph;
    int size;
    
    public ReverseGraph()       
    {
        size = 11;
        buildGraph();
        initGraph();
        transposeGraph();
    }
    
    private void buildGraph()
    {
        graph = new GraphNode[size];
    }
    
    private void initGraph()
    {
        GraphNode<T> nodeA = new GraphNode('A');
        GraphNode<T> nodeB = new GraphNode('B');
        GraphNode<T> nodeC = new GraphNode('C');
        GraphNode<T> nodeD = new GraphNode('D');
        GraphNode<T> nodeE = new GraphNode('E');
        GraphNode<T> nodeF = new GraphNode('F');
        GraphNode<T> nodeG = new GraphNode('G');
        GraphNode<T> nodeH = new GraphNode('H');
        GraphNode<T> nodeI = new GraphNode('I');
        GraphNode<T> nodeJ = new GraphNode('J');
        GraphNode<T> nodeK = new GraphNode('K');
        
        nodeA.neighBours.add(nodeB);
        nodeB.neighBours.add(nodeC);
        nodeC.neighBours.add(nodeA);
        nodeC.neighBours.add(nodeB);
        nodeB.neighBours.add(nodeD);
        
        nodeD.neighBours.add(nodeE);
        nodeE.neighBours.add(nodeF);
        nodeF.neighBours.add(nodeD);

        nodeG.neighBours.add(nodeF);
        nodeG.neighBours.add(nodeH);
        nodeH.neighBours.add(nodeI);
        nodeI.neighBours.add(nodeJ);
        nodeJ.neighBours.add(nodeK);
        nodeJ.neighBours.add(nodeG);
        
        graph[0] = nodeA;
        graph[1] = nodeB;
        graph[2] = nodeC;
        graph[3] = nodeD;
        graph[4] = nodeE;
        graph[5] = nodeF;
        graph[6] = nodeG;
        graph[7] = nodeH;
        graph[8] = nodeI;
        graph[9] = nodeJ;
        graph[10] = nodeK;        
    }
    
    public void transposeGraph()
    {
        HashMap<T, GraphNode<T>> map = new HashMap();
        for(int i = 0; i < size;i++)
        {
            GraphNode<T> newNode = new GraphNode(graph[i].val);
            map.put(newNode.val, newNode);
        }
        
        
        for(int i = 0; i < size;i++)
        {
            GraphNode<T> currentNode = graph[i];
            
            for(GraphNode<T> n : currentNode.neighBours)
            {
               GraphNode<T> transpose = map.get(n.val);
               transpose.neighBours.add(currentNode);
            }
        }
            
        printGraph(map);
    }
    
    private void printGraph(HashMap<T, GraphNode<T>> map)
    {
        for(T key : map.keySet())
        {
            GraphNode<T> currentNode = map.get(key);
            System.out.print("currentNode = " + currentNode.val + " neighbour values = ");
            for(GraphNode neighbour : currentNode.neighBours)
            {
                System.out.print(neighbour.val + " ");
            }
            System.out.println();
        }
    }
    
    
    
}
