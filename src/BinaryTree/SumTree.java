package BinaryTree;

import GraphAlgos.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree {

    BinaryNode node1;

    public SumTree()
    {
        node1 = new BinaryNode(1);

        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node8 = new BinaryNode(8);

        node1.right = node3;
        node1.left = node2;

        node1.left.right = node4;
        node1.right.left = node5;

        node1.right.right = node6;
        node1.right.left.left = node7;
        node1.right.left.right = node8;

        initSumTree(node1);
        levelOrderPrint(node1);
    }

    private int initSumTree(BinaryNode node){

        if(node == null)
            return 0;

        int leftSum = initSumTree(node.left);
        int rightSum = initSumTree(node.right);

        int old = node.val;

        node.val = rightSum + leftSum;

        return node.val + old;
    }

    public static void levelOrderPrint(BinaryNode root)
    {
        Queue<BinaryNode> q = new LinkedList<>();
        q.offer(root);

        System.out.println("print level order");
        while(!q.isEmpty())
        {
            BinaryNode temp = q.poll();
            System.out.println(temp.val + " ");

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }


}
