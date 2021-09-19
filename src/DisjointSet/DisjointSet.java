package DisjointSet;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    // node num ----> parent num
    Map<Integer, Integer> parents;
    Map<Integer, Integer> ranks;

    public DisjointSet()
    {
        parents = new HashMap<>();
        ranks = new HashMap<>();
    }

    public void makeSet(int num)
    {
        parents.put(num, num);
        ranks.put(num, 0);
    }

    //Finding the parent with path compression
    public int find(int num)
    {
        int current = num;
        while (parents.get(current) != current)
        {
            current = parents.get(current);
        }
        int root = current;

        current = num;
        int next = parents.get(num);
        while(next != root)
        {
            parents.put(current, root);
            current = next;
            next = parents.get(next);
        }


        return root;
    }

    public void print()
    {
        for (int key : parents.keySet())
        {
            System.out.println("Key : " + key + "-->  parent : " + parents.get(key));
        }
    }

    public void printRanks()
    {
        for (int key : ranks.keySet())
        {
            System.out.println("key : " + key + " ----> rank : " + ranks.get(key));
        }
    }

    public void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (ranks.get(rootY) > ranks.get(rootX))// making sure rootX has higher rank
        {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parents.replace(rootY, rootX);
        if (ranks.get(rootY) == ranks.get(rootX))
            ranks.replace(rootX, ranks.get(rootX) + 1);
    }

}
