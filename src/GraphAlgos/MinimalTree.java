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

//Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
//algorithm to create a binary search tree with minimal height.

public class MinimalTree {
    
    public BinaryNode root;
    
    public MinimalTree()
    {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        root = buildMinimalTree(arr, 0, arr.length - 1);
        inOrder(root);
    }
    
    // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 -- 9 -- 10 -- 11 -- 12
    public BinaryNode buildMinimalTree(int[] sorted, int left, int right)
    {
        if(left > right)
            return null;
        
        int mid = left + (right - left) / 2;
        
        BinaryNode newNode = new BinaryNode(sorted[mid]);
        
        newNode.right = buildMinimalTree(sorted, mid + 1, right);
        newNode.left = buildMinimalTree(sorted, left, mid - 1);   
        
        return newNode;
    }
    
    public void inOrder(BinaryNode root)
    {
        if(root == null)
            return;
        
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}

