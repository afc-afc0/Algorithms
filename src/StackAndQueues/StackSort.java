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
public class StackSort
{
    //    Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
    //an additional temporary stack, but you may not copy the elements into any other data structure
    //(such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
    
    
    
    public static java.util.Stack<Integer> sortStack(java.util.Stack<Integer> unSorted)
    {
        java.util.Stack<Integer> sorted = new java.util.Stack();
        
        while(!unSorted.isEmpty())
        {
            int val = unSorted.pop();
            
            int count = 0;
            while(!sorted.isEmpty() && sorted.peek() < val)
            {
                unSorted.push(sorted.pop());
                count++;
            }
            
            sorted.push(val);
            
            for(int i = 0; i < count;i++)
                sorted.push(unSorted.pop());
        }
        
        return sorted;
    }
}
