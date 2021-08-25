/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

/**
 *
 * @author ahmet
 */

//4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
//this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//node never differ by more than one.

public class CheckBalanced {
    
    BinaryNode root;
    
    public CheckBalanced()
    {
        buildTree();
    }
    
    private void buildTree()
    {
        root = new BinaryNode(1);        
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        
        root.left = node2;
        root.right = node3;
        
        node2.left = node4;
        node2.right = node5;
        
        node3.left = node6;
        
        BinaryNode node7 = new BinaryNode(7);
        node4.left = node7;
        
        BinaryNode node8 = new BinaryNode(8);
        node7.left = node8;
//        
//        BinaryNode node9 = new BinaryNode(9);
//        node8.left = node9;
        
        System.out.println(isBalanced());
    }
    
    private boolean isBalanced()
    {
        return helper(root) != -1;
    }
    
    private int helper(BinaryNode node)
    {
        if(node == null)
            return 0;
        
        int leftHeight = helper(node.left);
        if(leftHeight == -1)
            return -1;
        
        
        int rightHeight = helper(node.right);
        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}
