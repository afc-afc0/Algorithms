package BinaryTree;

import GraphAlgos.BinaryNode;

import java.util.ArrayList;

public class FindCousins {

    BinaryNode root;

    public FindCousins()
    {
        root = new BinaryNode(1);

        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node8 = new BinaryNode(8);

        root.right = node3;
        root.left = node2;

        root.left.right = node4;
        root.right.left = node5;

        root.right.right = node6;
        root.right.left.left = node7;
        root.right.left.right = node8;

        getCousins(node4);
    }

    private ArrayList<Integer> getCousins(BinaryNode node) {

        ArrayList<Integer> result = new ArrayList<>();

        int nodeLevel = getLevel(root, node, 0);

        inOrder(root, node, result, nodeLevel);

        for(int num : result)
            System.out.println(num);

        return result;
    }

    private void inOrder(BinaryNode root, BinaryNode node ,ArrayList<Integer> result, int level)
    {
        if (root == null)
            return;

        if(level == 0)
        {
            result.add(root.val);
            return;
        }

        if((root.right != null && root.right != node) || (node.left != null && node.left != node))
        {
            inOrder(root.left, node, result, level - 1);
            inOrder(root.right, node, result, level -1);
        }
    }
    
    private int getLevel(BinaryNode root ,BinaryNode find, int level){

        if(root == null)
            return -1;

        if(find == root)
            return  level;

        int left = getLevel(root.left, find, level + 1);
        int right = getLevel(root.right, find, level + 1);


        if(left == -1 && right == -1)
            return -1;

        return left > right ? left : right;
    }

}
