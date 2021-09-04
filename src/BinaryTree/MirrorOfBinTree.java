package BinaryTree;

import GraphAlgos.BinaryNode;

import static BinaryTree.SumTree.levelOrderPrint;

public class MirrorOfBinTree {

    BinaryNode root;

    public MirrorOfBinTree(){
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

        mirror(root);
        levelOrderPrint(root);
    }

    private void mirror(BinaryNode root) {
        takeMirror(root);
    }

    private void takeMirror(BinaryNode node)
    {
        if (node == null)
            return;

        takeMirror(node.left);
        takeMirror(node.right);
        swap(node.left, node.right);
    }

    private void swap(BinaryNode first, BinaryNode second)
    {
        BinaryNode temp = first;
        first = second;
        second = temp;
    }


}
