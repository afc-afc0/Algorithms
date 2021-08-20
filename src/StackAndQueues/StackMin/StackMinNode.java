/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueues.StackMin;

/**
 *
 * @author ahmet
 */
public class StackMinNode
{
    public int minSoFar;
    public int val;
    public StackMinNode next;

    public StackMinNode(int val) {
        this.val = val;
        this.minSoFar = Integer.MAX_VALUE;
    }
    
    public StackMinNode(int val, int minSoFar)
    {
        this.val = val;
        this.minSoFar = minSoFar;
    }
}
