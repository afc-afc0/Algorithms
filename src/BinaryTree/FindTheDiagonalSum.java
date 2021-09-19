package BinaryTree;

import GraphAlgos.BinaryNode;

import java.util.ArrayList;

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
        ArrayList<Integer> result = new ArrayList<>();
        getDiagonalSum(root, 0,result);
        for (int num : result)
            System.out.println(num);
    }

    private void getDiagonalSum(BinaryNode root, int currentDiagonal, ArrayList<Integer> result) {

        if (root == null)
            return;

        while(result.size() <= currentDiagonal)
            result.add(0);

        result.set(currentDiagonal, result.get(currentDiagonal) + root.val);
        getDiagonalSum(root.left, currentDiagonal, result);
        getDiagonalSum(root.right, currentDiagonal + 1, result);
    }



}
