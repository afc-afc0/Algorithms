/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import Graphs.Edge;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ahmet
 */

//public class MinimalEdge {
//    public int source, destinetion, weight;
//    
//    public MinimalEdge(int source, int destinetion, int weight)
//    {
//        this.source = source;
//        this.destinetion = destinetion;
//        this.weight = weight;
//    }
//}

public class BellmanFord {
    
    
    public static void BellmanFord(ArrayList<MinimalEdge> edges, int start, int graphSize)
    {        
        int[] distances = new int[graphSize + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        
        for(int j = 0; j < graphSize - 1;j++)
        {
            for(int i = 0;i < edges.size();i++)
            {
                MinimalEdge currentEdge = edges.get(i);
                int targetWeight = distances[currentEdge.target];
                int sourceWeight = distances[currentEdge.source];
                int edgeWeight = currentEdge.weight;

                if(sourceWeight == Integer.MAX_VALUE)
                    continue;

                if(sourceWeight + edgeWeight < targetWeight)
                    distances[currentEdge.target] = sourceWeight + edgeWeight;
            }
        }
        
        
        for(int i = 0; i < edges.size();i++)
        {
            MinimalEdge currentEdge = edges.get(i);
            int targetWeight = distances[currentEdge.target];
            int sourceWeight = distances[currentEdge.source];
            int edgeWeight = currentEdge.weight;
            
            if(sourceWeight + edgeWeight < targetWeight)
            {
                System.out.println("found negative circle");
                distances[currentEdge.target] = Integer.MIN_VALUE;
            }
        }
        
        
        for(int i = 1;i < graphSize + 1;i++)
        {
            System.out.println("Distance to " + i + " = " + distances[i]);
        }    
    }
    
}
