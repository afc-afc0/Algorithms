package GraphAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.openmbean.ArrayType;



// return the edges that are bridge
public class CheckIfGraphHasNoBridges {
    
    private class Edge
    {
        int source;
        int target;

        Edge(int source, int dest) {
            this.source = source;
            this.target = dest;
        }
    }

    private class Graph
    {
        List<List<Integer>> adjList = new ArrayList<>();
        
        Graph(List<Edge> edges, int size)
        {
           
            adjList = new ArrayList<>();
            for (int i = 0; i < size; i++)
                adjList.add(new ArrayList<Integer>());

            for (Edge edge : edges) 
                adjList.get(edge.source).add(edge.target);
        }
    }

    public CheckIfGraphHasNoBridges() {
        init();
    }

    private void init()
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 2),
                new Edge(2, 3), new Edge(2, 4),
                new Edge(3, 4), new Edge(3, 5)
        );
 
        // total number of nodes in the graph
        final int N = 6;
 
        // construct graph
        Graph graph = new Graph(edges, N);
    
        List<int[]> result = new ArrayList<>();

        int time = 0;

        boolean[] visited = new boolean[N];

        int[] arrivals = new int[N];

        getBridges(graph, 0, -1, arrivals, time, visited, result);
    } 

    public int getBridges(Graph graph, int currrent, int parent, int[] arrivals ,int time, boolean[] visited, List<int[]> result)
    {
        visited[currrent] = true;
        arrivals[currrent] = time++;

        int min = arrivals[currrent];
        for (int target : graph.adjList.get(currrent))
        {
            if (!visited[target])
                min = Math.min(min, getBridges(graph, target, currrent, arrivals, time, visited, result));

            if (parent != target)
            {
                min = Math.min(arrivals[target], min);
            }
        }

        if (min == arrivals[currrent] && parent != -1)
        {
            result.add(new int[]{currrent, parent});
        }

        return min;
    } 



}
