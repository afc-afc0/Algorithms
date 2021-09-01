package GraphAlgos;

//Very easy topological sort algorithm the difference is this time we use BFS to keep track of the level
//In DFS we was storing the visited nodes this time we will just store the nodes with 0 incoming nodes
//https://www.youtube.com/watch?v=cIBFEhD77b4&t=7s

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {

    ArrayList<ArrayList<Integer>> graph;

    public KahnsAlgo()
    {
        graph = new ArrayList<>();
        initGraph();
    }

    private void initGraph() {
        ArrayList<Integer> node0 = new ArrayList<>();
        node0.add(2);
        node0.add(3);
        node0.add(6);

        ArrayList<Integer> node1 = new ArrayList<>();
        node1.add(4);

        ArrayList<Integer> node2 = new ArrayList<>();
        node2.add(6);

        ArrayList<Integer> node3 = new ArrayList<>();
        node3.add(1);
        node3.add(4);

        ArrayList<Integer> node4 = new ArrayList<>();
        node4.add(5);
        node4.add(8);

        ArrayList<Integer> node5 = new ArrayList<>();

        ArrayList<Integer> node6 = new ArrayList<>();
        node6.add(7);
        node6.add(11);

        ArrayList<Integer> node7 = new ArrayList<>();
        node7.add(4);
        node7.add(12);

        ArrayList<Integer> node8 = new ArrayList<>();

        ArrayList<Integer> node9 = new ArrayList<>();
        node9.add(2);
        node9.add(10);

        ArrayList<Integer> node10 = new ArrayList<>();
        node10.add(6);

        ArrayList<Integer> node11 = new ArrayList<>();
        node11.add(12);

        ArrayList<Integer> node12 = new ArrayList<>();
        node12.add(8);


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
        graph.add(node11);
        graph.add(node12);


        ArrayList<Integer> result = runTopologicalSort();
        printResult(result);
    }

    public ArrayList<Integer> runTopologicalSort()
    {
        ArrayList<Integer> result = new ArrayList();
        Queue<Integer> queue = new LinkedList<>();
        int[] incoming = initIncomingEdges();
            
        for(int i = 0; i < graph.size();i++)
        {
            if(incoming[i] == 0)
            {
                queue.add(i);
            }
        }

        while(queue.size() > 0)
        {
            Integer node = queue.poll();
            result.add(node);
            for(Integer edge : graph.get(node))
            {
                incoming[edge]--;
                if(incoming[edge] == 0)
                    queue.add(edge);
            }
        }

        return result;
    }

    private int[] initIncomingEdges()
    {
        int[] incomingDegrees = new int[graph.size()];
        for(ArrayList<Integer> list : graph)
        {
            for(Integer edge : list)
            {
                incomingDegrees[edge]++;
            }
        }

        return incomingDegrees;
    }

    private void printResult(ArrayList<Integer> list)
    {
        for(int num : list)
            System.out.println(num);
    }

}
