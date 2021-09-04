package BinaryTree;

import GraphAlgos.BinaryNode;

public class MaxDiameter {

    BinaryNode root;

    public MaxDiameter(){
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

        root.right = node3;
        root.left = node2;

        root.left.right = node4;
        root.right.left = node5;

        root.right.right = node6;
        root.right.left.left = node7;
        root.right.left.right = node8;

        System.out.println(getDiameter(root));
    }

    private int getDiameter(BinaryNode root) {

        if(root.right == null && root.left == null)
            return 1;

        int leftDia = 0;
        if(root.left != null)
            leftDia = getDiameter(root.left);

        int rightDia = 0;
        if(root.right != null)
            rightDia = getDiameter(root.right);

        return Math.max(leftDia, rightDia) + 1;
    }

}
