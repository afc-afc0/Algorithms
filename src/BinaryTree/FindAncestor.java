package BinaryTree;

import GraphAlgos.BinaryNode;

public class FindAncestor {

    BinaryNode root;

    public FindAncestor(){
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
        BinaryNode result = findAncestor(node4, node6);
        System.out.println(result.val);
    }

    private BinaryNode findAncestor(BinaryNode first, BinaryNode second) {
        BinaryNode lca = null;
        BinaryNodeWrapper wrapper = new BinaryNodeWrapper(lca);

        if(isPresent(root, first) && isPresent(root,second))
        {
            helper(root, first, second, wrapper);
            return wrapper.node;
        }

        return null;
    }

    private boolean helper(BinaryNode root, BinaryNode first, BinaryNode second, BinaryNodeWrapper wrapper)
    {
        if(root == null)
            return false;

        if(root == first || root == second){
            wrapper.node = root;
            return true;
        }

        boolean left = helper(root.left, first, second, wrapper);
        boolean right = helper(root.right, first, second, wrapper);

        if(left && right)//This happens just once
            wrapper.node = root;

        return left || right;
    }

    private boolean isPresent(BinaryNode root, BinaryNode node)
    {
        if(root == null)
            return false;

        if(root == node)
            return true;

        return isPresent(root.left, node) || isPresent(root.right, node);
    }

    private class BinaryNodeWrapper
    {
        public BinaryNode node;

        BinaryNodeWrapper(BinaryNode node){
            this.node = node;
        }
    }
}
