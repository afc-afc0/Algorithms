package BinaryTree;

import GraphAlgos.BinaryNode;

public class SinkZeros {

    BinaryNode root;

    public SinkZeros(){
        root = new BinaryNode(0);

        BinaryNode node2 = new BinaryNode(1);
        BinaryNode node3 = new BinaryNode(0);
        BinaryNode node4 = new BinaryNode(0);
        BinaryNode node5 = new BinaryNode(2);
        BinaryNode node6 = new BinaryNode(3);
        BinaryNode node7 = new BinaryNode(4);

        root.left = node2;
        root.right = node3;

        node3.left = node4;
        node3.right = node5;

        node4.left = node6;
        node4.right = node7;


        sinkZeros(root);
        printPostorder(root);
    }

    private void printPostorder(BinaryNode node){
        if(node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.val);
    }

    private void sinkZeros(BinaryNode node) {
        if(node == null)
            return;

        sinkZeros(node.left);
        sinkZeros(node.right);
        if(node.val == 0)
            sink(node, node);
    }

    private void sink(BinaryNode current, BinaryNode sinkingNode)
    {
        if(isValidPosition(current))
        {
            swap(current, sinkingNode);
            return;
        }

        sink(current.left, sinkingNode);
        sink(current.right, sinkingNode);
    }

    private void swap(BinaryNode source, BinaryNode target){
        int temp = source.val;
        source.val = target.val;
        target.val = temp;
    }

    private boolean isValidPosition(BinaryNode node){
        if(node.right == null && node.left == null)
            return true;

        if((node.right != null && node.right.val == 0) && (node.left != null && node.left.val == 0))
            return true;

        if ((node.right != null && node.right.val == 0) && node.left == null)
            return true;

        if((node.left != null && node.left.val == 0) && node.right == null)
            return true;

        return false;
    }

}
