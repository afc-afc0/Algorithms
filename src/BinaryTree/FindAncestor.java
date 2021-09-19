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

        BinaryNode node10 = new BinaryNode(10);

        findLCA(node7, node10);
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



    private class TwoNodeWrapper{
        public BinaryNode first;
        public BinaryNode second;

        public TwoNodeWrapper(){
            first = null;
            second = null;
        }
    }

    BinaryNode result = null;
    private BinaryNode findLCA(BinaryNode node1, BinaryNode node2){

        findLCAUtil(root, node1, node2);

        if(result == null){
            System.out.println("Couldn't found LCA");
        }

        return result;
    }

    //We are assuming both nodes are on the tree otherwise will return the first node that we found
    private boolean findLCAUtil(BinaryNode currentNode, BinaryNode first, BinaryNode second){

        if (currentNode == null)
            return false;

        if (currentNode == first || currentNode == second) {
            result = currentNode;
            return true;
        }
        boolean left = findLCAUtil(currentNode.left, first, second);
        boolean right = findLCAUtil(currentNode.right, first, second);

        if(left && right)
            result = currentNode;

        return left || right;
    }

    private boolean findLCAUtil(BinaryNode currentNode, BinaryNode first, BinaryNode second, TwoNodeWrapper wrapper){
        if(currentNode == null)
            return false;

        if(currentNode == first) {
            wrapper.first = currentNode;
            return true;
        }

        if(currentNode == second){
            wrapper.second = currentNode;
            return true;
        }

        boolean left = findLCAUtil(currentNode.left, first, second, wrapper);
        boolean right = findLCAUtil(currentNode.right, first, second, wrapper);

        if(left && right) {
            result = currentNode;
        }
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
