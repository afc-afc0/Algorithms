package GraphAlgos;

import java.util.*;


public class SSSPOnDag {

    private class Edge{

        Character source;
        Character target;
        int weight;

        public Edge(Character source, Character target, int weight){
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    Map<Character, List<Edge>> graph;

    public SSSPOnDag(){
        initGraph();
    }

    private void initGraph() {

        graph = new HashMap<>();

        ArrayList<Edge> nodeA = new ArrayList<>();
        nodeA.add(new Edge('A', 'B', 3));
        nodeA.add(new Edge('A', 'C', 6));

        ArrayList<Edge> nodeB = new ArrayList<>();
        nodeB.add(new Edge('B', 'E', 14));
        nodeB.add(new Edge('B', 'D', 4));
        nodeB.add(new Edge('B', 'C', 4));

        ArrayList<Edge> nodeC = new ArrayList<>();
        nodeC.add(new Edge('C', 'D', 8));
        nodeC.add(new Edge('C', 'G', 11));

        ArrayList<Edge> nodeD = new ArrayList<>();
        nodeD.add(new Edge('D', 'E', -4));
        nodeD.add(new Edge('D', 'F', 5));
        nodeD.add(new Edge('D', 'G', 2));

        ArrayList<Edge> nodeE = new ArrayList<>();
        nodeE.add(new Edge('E', 'H', 9));

        ArrayList<Edge> nodeF = new ArrayList<>();
        nodeF.add(new Edge('F','H', 1));

        ArrayList<Edge> nodeG = new ArrayList<>();
        nodeG.add(new Edge('G', 'H', 2));

        ArrayList<Edge> nodeH = new ArrayList<>();

        graph.put('A', nodeA);
        graph.put('B', nodeB);
        graph.put('C', nodeC);
        graph.put('D', nodeD);
        graph.put('E', nodeE);
        graph.put('F', nodeF);
        graph.put('G', nodeG);
        graph.put('H', nodeH);

        Map<Character, Integer> result = findSSSP('A', graph);

        System.out.println("Printing result");
        for (Character node : result.keySet()){
            System.out.println("Node = " + node + " , distance = " + result.get(node));
        }
    }

    private Map<Character, Integer> findSSSP(Character root, Map<Character, List<Edge>> graph) {

        Map<Character, Integer> result = initResult(graph);
        result.put(root, 0);
        Map<Character, Integer> incoming = initIncoming(graph);

        Character[] topologicalSort = topologicalSort(graph, incoming);

        for(int i = 0; i < topologicalSort.length;i++){

            for(Edge edge : graph.get(topologicalSort[i])){
                relax(result, edge);
            }
        }

        return result;
    }

    private void relax(Map<Character, Integer> result, Edge edge) {

        int sourceWeight = result.get(edge.source);
        int targetWeight = result.get(edge.target);
        int edgeWeight = edge.weight;

        if(targetWeight > sourceWeight + edgeWeight){//update the value
            result.put(edge.target, sourceWeight + edgeWeight);
        }
    }

    private Map<Character, Integer> initResult(Map<Character, List<Edge>> graph) {

        HashMap<Character, Integer> result = new HashMap<>();

        for(Character node : graph.keySet())
            result.put(node, Integer.MAX_VALUE);

        return result;
    }


    private Map<Character, Integer> initIncoming(Map<Character, List<Edge>> graph) {

        HashMap<Character, Integer> incoming = new HashMap<>();

        for (Character source : graph.keySet())
            incoming.put(source, 0);

        for (Character source : graph.keySet()){
            List<Edge> edges = graph.get(source);
            for (Edge edge : edges){
                Character target = edge.target;
                Integer count = incoming.get(target);
                count++;
                incoming.put(target, count);
            }
        }

        /*System.out.println("Incoming");
        for (Character node : incoming.keySet()){
            System.out.println("Character = " + node + "  incoming count = " + incoming.get(node));
        }*/

        return incoming;
    }



    private Character[] topologicalSort(Map<Character, List<Edge>> graph, Map<Character, Integer> incoming) {

        int sortedIndex = 0;
        Character[] sorted = new Character[incoming.size()];

        Queue<Character> q = new LinkedList<>();
        for (Character node : incoming.keySet()) {
            if (incoming.get(node) == 0)
                q.add(node);

        }

        while (!q.isEmpty()){

            Character node = q.poll();
            sorted[sortedIndex++] = node;

            for (Edge edge : graph.get(node)){
                Character target = edge.target;
                int incomingEdgeCount = incoming.get(target);
                incomingEdgeCount--;
                incoming.put(target, incomingEdgeCount);
                if(incomingEdgeCount == 0)
                    q.add(target);
            }
        }

        return sorted;
    }

}
