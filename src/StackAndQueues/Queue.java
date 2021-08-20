/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueues;

import LinkedList.ListNode;
import java.util.NoSuchElementException;

/**
 *
 * @author ahmet
 */
//poll
//offer
public class Queue {
    ListNode head;
    ListNode tail;
    
    public Queue()
    {
        head = null;
        tail = null;
    }
    
    public void offer(ListNode newNode)
    {
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            return;
        }
        
        tail.next = newNode;
        tail = tail.next;
    }
    
    public void printTail()
    {
        System.out.println(tail.val);
    }
    
    public ListNode poll()
    {
        if(head == null)//throw exception
            throw new NoSuchElementException();
        
        ListNode result = head;
        head = head.next;
      
        if(head == null)
            tail = null;
        
        return result;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
}
