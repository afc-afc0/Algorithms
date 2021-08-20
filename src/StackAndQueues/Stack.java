/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueues;

/**
 *
 * @author ahmet
 */

// 1 2 3 4 5 6 

public class Stack<T> {
    StackNode<T> head; 
    
    public Stack()
    {
        head = null;
    }
    
    public void push(StackNode<T> newNode)
    {
        if(newNode == null)
            return;
        
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public StackNode<T> pop()
    {
        if(head == null)//should throw exception
            return head;
        
        StackNode result = head;
        head = head.next;
        
        return result;
    }
}

//public class StackNode<T> {
//    T val;
//    StackNode<T> next;
//    
//    public StackNode(T val)
//    {
//        this.val = val;
//    }
//}