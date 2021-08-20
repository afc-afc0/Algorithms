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
public class StackMin {
    
    StackMinNode head;
    int min;
    
    public StackMin()
    {
        head = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) 
    {
        StackMinNode newNode = new StackMinNode(val, val < min ? val : min);
        
        newNode.next = head;
        head = newNode;
        updateMin();  
    }
    
    public int pop() throws Exception
    {
        if(head == null)
            throw new Exception();
        
        StackMinNode node = head;
        head = head.next;
        
        updateMin();
        
        return node.val;
    }
    
    public void updateMin()
    {
        min = head.minSoFar;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int getMin()
    {
        return min;
    }
    
    public void printMin()
    {
        System.out.println("Min = " + min);
    }
    
}
