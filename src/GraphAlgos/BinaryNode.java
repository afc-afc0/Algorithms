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


public class BinaryNode {
    public BinaryNode right;
    public BinaryNode left;
    public BinaryNode parent;
    public int val;
    
    public BinaryNode(int val)
    {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
