package BinaryTree;

import GraphAlgos.BinaryNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrintPaths {

    private class WrapBoolean
    {
        public boolean val;
    }


    BinaryNode root;

    public PrintPaths(){
        initTree();
    }

    private void initTree() {
        root = new BinaryNode(1);

        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node8 = new BinaryNode(8);
        BinaryNode node9 = new BinaryNode(9);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node6.left = node8;

        node7.right = node9;

        ArrayList<Integer> result = new ArrayList<>();
        WrapBoolean isFound2 = new WrapBoolean();
        isFound2.val = false;
        AtomicBoolean isFound = new AtomicBoolean(false);
        findAncestors2(root, node9, result, isFound2);
        printList(result);
    }

    private void printList(List<Integer> list)
    {
        for (int num : list)
            System.out.print(num + " ");
        System.out.println();
    }

    private void findAncestors(BinaryNode node, BinaryNode find, ArrayList<Integer> path, AtomicBoolean isFound)
    {
        if(node == null)
            return;

        if(node == find) {
            isFound.set(true);
            return;
        }
        path.add(node.val);

        findAncestors(node.left, find, path, isFound);
        findAncestors(node.right, find, path, isFound);

        if (!isFound.get())
            path.remove(path.size() - 1);
    }

    private void findAncestors2(BinaryNode node, BinaryNode find, ArrayList<Integer> path, WrapBoolean isFound)
    {
        if(node == null)
            return;

        if(node == find)
        {
            isFound.val = true;
            return;
        }

        path.add(node.val);

        findAncestors2(node.left, find, path, isFound);
        findAncestors2(node.right, find, path, isFound);

        if (isFound.val == false)
            path.remove(path.size() - 1);
    }

    private void findDistance(BinaryNode first, BinaryNode second)
    {
        findCommonAncestor(first, second);
    }

    private void findCommonAncestor(BinaryNode first, BinaryNode second) {
        
    }

    private void printArrayList(ArrayList<ArrayList<Integer>> lists)
    {
        for (ArrayList<Integer> path : lists)
        {
            for (Integer num : path)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    private void getPaths(BinaryNode node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {

        if(node.left == null && node.right == null) {
            path.add(node.val);
            result.add( new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(node.val);
        if(node.left != null) {
            getPaths(node.left, path, result);
        }
        if(node.right != null) {
            getPaths(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }


}
