package BinaryTree;

import GraphAlgos.BinaryNode;

public class FindTheDiagonalSum {

    BinaryNode root;

    public FindTheDiagonalSum(){
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

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node5.left = node7;
        node5.right = node8;

    }

    private void printIntArr(int[] arr)
    {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }


    private int getLeftHeight(BinaryNode root) {
        if(root == null)
            return 0;

        int count = 0;
        BinaryNode temp = root;
        while(temp != null){
            count++;
            temp = temp.left;
        }

        return count;
    }

    private int getRightHeight(BinaryNode root) {
        if(root == null)
            return 0;

        int count = 0;
        BinaryNode temp = root;
        while(temp != null){
            count++;
            temp = temp.right;
        }

        return count;
    }


}
