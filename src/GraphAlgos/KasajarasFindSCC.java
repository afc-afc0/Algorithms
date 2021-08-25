/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author ahmet
 */
public class KasajarasFindSCC {
    
    ArrayList<ArrayList<Integer>> graph;
    ArrayList<Integer>[] transpose;
    
    Stack<Integer> stack;
    boolean[] visited;
    
    public KasajarasFindSCC(){
        graph = new ArrayList();
        stack = new Stack();
        buildGraph();
        visited = new boolean[graph.size() + 1];
        getSCC();
    }
    
    private void buildGraph()
    {
        ArrayList<Integer> node0 = new ArrayList();
        node0.add(1);
        
        ArrayList<Integer> node1 = new ArrayList();
        node1.add(2);
        node1.add(3);
        
        ArrayList<Integer> node2 = new ArrayList();
        node2.add(0);
        
        ArrayList<Integer> node3 = new ArrayList();
        node3.add(4);
        
        ArrayList<Integer> node4 = new ArrayList();
        node4.add(5);
        
        ArrayList<Integer> node5 = new ArrayList();
        node5.add(3);
        
        ArrayList<Integer> node6 = new ArrayList();
        node6.add(5);
        node6.add(7);
        
        ArrayList<Integer> node7 = new ArrayList();
        node7.add(8);
        
        ArrayList<Integer> node8 = new ArrayList();
        node8.add(9);
        
        ArrayList<Integer> node9 = new ArrayList();
        node9.add(10);
        node9.add(6);
        
        ArrayList<Integer> node10 = new ArrayList();
        
        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
        graph.add(node6);
        graph.add(node7);
        graph.add(node8);
        graph.add(node9);
        graph.add(node10);
    }
    
    public KasajarasFindSCC(ArrayList<ArrayList<Integer>> graph)
    {
        this.graph = graph;
        stack = new Stack();
        visited = new boolean[graph.size()];
    }
    
    public HashMap<Integer, ArrayList<Integer>> getSCC()
    {        
        for(int i = 0; i < graph.size();i++)
        {
            if(visited[i])
                continue;
            
            DFS(i);
        }
        
        initTranspose();
        resetVisited();
        HashMap<Integer, ArrayList<Integer>> result = new HashMap();
        int currentSCC = 0;
        
        while(!stack.isEmpty())
        {
            int currentIndex = stack.pop();
            if(visited[currentIndex])
                continue;
            
            
            dfsForTranspose(currentIndex, currentSCC, result);
            currentSCC++;
        }
            
        printMap(result);
        return result;
    }
    
    private void dfsForTranspose(int index, int currentSCC, HashMap<Integer, ArrayList<Integer>> result)
    {
        if(visited[index])
            return;
        
        visited[index] = true;
        if(!result.containsKey(currentSCC))
            result.put(currentSCC, new ArrayList<>());
            
        result.get(currentSCC).add(index);
        
        ArrayList<Integer> adjList = transpose[index];
        for(int i = 0; i < adjList.size();i++)
        {
            if(visited[adjList.get(i)])
                continue;
            
            dfsForTranspose(adjList.get(i), currentSCC, result);
        }
    }
    
    private void resetVisited()
    {
        Arrays.fill(visited, false);
    }
    
    private void initTranspose()
    {
        transpose = new ArrayList[graph.size()];
        for(int i = 0; i < graph.size();i++)
            transpose[i] = new ArrayList();
        
        
        for(int sourceIndex = 0;sourceIndex < graph.size();sourceIndex++)
        {
            for(int j = 0; j < graph.get(sourceIndex).size();j++)
            {
                int targetIndex = graph.get(sourceIndex).get(j);
                transpose[targetIndex].add(sourceIndex);
            }
        }
       
    }
    

    
    
    private void DFS(int nodeIndex)
    {
        if(visited[nodeIndex])
            return;
        
        visited[nodeIndex] = true;
        
        for(Integer neighbour : graph.get(nodeIndex))
        {
            if(visited[neighbour])
                continue;
            
            DFS(neighbour);
        }
        
        stack.push(nodeIndex);
    }

    private void printMap(HashMap<Integer, ArrayList<Integer>> result) {

        for(int key : result.keySet()){
            ArrayList<Integer> island = result.get(key);
            System.out.print("Island " + key + " nodes = ");
            for(int num : island)
                System.out.print(num + " ");
            
            System.out.println();
        }
    }
    
}
