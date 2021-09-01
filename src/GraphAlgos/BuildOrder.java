package GraphAlgos;

import java.util.*;

public class BuildOrder {

    char[] inputChars;
    char[][] input;

    public BuildOrder(){
        initInput();
    }

    private void initInput() {
        inputChars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        input = new char[6][2];

        input[0][0] = 'a';
        input[0][1] = 'd';

        input[1][0] = 'f';
        input[1][1] = 'b';

        input[2][0] = 'b';
        input[2][1] = 'd';

        input[3][0] = 'f';
        input[3][1] = 'a';

        input[4][0] = 'd';
        input[4][1] = 'c';

        input[5][0] = 'd';
        input[5][1] = 'b';

        ArrayList<Character> result = buildOrder(inputChars, input);

        System.out.println("Result");
        if(result != null) {
            for (Character ch : result) {
                System.out.print(ch + " ");
            }
        }
        else
            System.out.println("Not a DAG");
    }

    public ArrayList<Character> buildOrder(char[] projects, char[][] projectDependencies) {
        //key = our node , value = edges as list
        HashMap<Character, ArrayList<Character>> graph = initGraph(projects, projectDependencies);
        HashMap<Character, Integer> incoming = initIncoming(graph);

        ArrayList<Character> result = new ArrayList<>();
        Queue<Character> q = initQueue(incoming);

        int visitedCount = projects.length;
        while(!q.isEmpty())
        {
            Character node = q.poll();
            visitedCount--;
            ArrayList<Character> edges = graph.get(node);

            for (Character edge : edges){
                int count = incoming.get(edge);
                count--;
                if(count == 0)
                    q.add(edge);
                incoming.put(edge, count);
            }
        }

        return visitedCount == 0 ? result : null;
    }

    private Queue<Character> initQueue(HashMap<Character, Integer> incoming) {

        Queue<Character> result = new LinkedList<>();

        for(Character key : incoming.keySet())
        {
            if(incoming.get(key) == 0)
                result.add(key);
        }

        return result;
    }

    private HashMap<Character, ArrayList<Character>> initGraph(char[] projects, char[][] dependencies) {

        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

        for(Character ch : projects)
        {
            graph.put(ch, new ArrayList());
        }

        for(char[] dependency : dependencies)
        {
            graph.get(dependency[0]).add(dependency[1]);
        }

        return graph;
    }

    private HashMap<Character, Integer> initIncoming(HashMap<Character, ArrayList<Character>> graph) {

        HashMap<Character, Integer> incoming = new HashMap<>();

        for(Character ch : graph.keySet())
        {
            incoming.put(ch, 0);
        }

        for(Character key : graph.keySet())
        {
            ArrayList<Character> edges = graph.get(key);

            for (Character target : edges)
            {
                int count  = incoming.get(target);
                count++;
                incoming.put(target, count);
            }
        }

        return incoming;
    }

    private void printMap(HashMap<Character,Integer> map)
    {
        for(Character key : map.keySet())
        {
            System.out.println("node = " + key + " , incoming edge count = " + map.get(key));
        }
    }

}
