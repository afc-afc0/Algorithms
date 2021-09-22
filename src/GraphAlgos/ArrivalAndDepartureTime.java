package GraphAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrivalAndDepartureTime
{
    private class Edge
    {
        int source, target;

        Edge(int source, int target)
        {
            this.source = source;
            this.target = target;
        }
    }

    private class Graph
    {
        List<List<Integer>> adjList;

        Graph(List<Edge> edges, int size)
        {
            adjList = new ArrayList<>();

            for (int i = 0; i < size; i++)
            {
                adjList.add(new ArrayList<>());
            }

            for (Edge edge : edges)
            {
                adjList.get(edge.source).add(edge.target);
            }
        }
    }



    public ArrivalAndDepartureTime() {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
                new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
                new Edge(4, 5), new Edge(6, 7)
        );
        int size = 8;

        Graph graph = new Graph(edges, size);

        int[] arrivals = new int[size];
        int[] departures = new int[size];
        boolean[] visited = new boolean[size];

        int time = 0;
        for (int i = 0; i < size; i++)
        {
            if (!visited[i])
            {
                time = DFS(graph, i, visited, arrivals, departures, time);
            }
        }
        for (int i = 0; i < size; i++)
            System.out.println("Node : " + i + " , arrival = " + arrivals[i] + " --- departure = " + departures[i]);
    }

    private int DFS(Graph graph, int currentNode, boolean[] visited, int[] arrivals, int[] departures, int time)
    {
        visited[currentNode] = true; 
        arrivals[currentNode] = time++;

        for (int target : graph.adjList.get(currentNode))
        {
            if (!visited[target])
            {
                time = DFS(graph, target, visited, arrivals, departures, time);
            }
        }

        departures[currentNode] = time++;;
        return time;
    } 



}

