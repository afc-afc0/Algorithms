/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueues.StackOfStacks;

import java.util.Stack;

/**
 *
 * @author ahmet
 */
//push() add new stack 
//pop()
//I will use normal stack
public class StackOfStacks<T> {
    
    public Stack<Stack<T>> stackOfStacks;
    int stackCapacity;//stack capacity for each stack
   
    public StackOfStacks(int stackCapacity) throws Exception
    {
        if(stackCapacity <= 0)
            throw new Exception();
        stackOfStacks = new Stack<Stack<T>>();
        this.stackCapacity = stackCapacity;
        pushStack();
    }
    
    
    public void push(T val)
    {
        if(peekStackSize() == stackCapacity)
        {
            //Create new stack and push value to that stack
            pushStack();
        }
        
        pushToPeekStack(val);
    }
    
    public void pushToPeekStack(T val)
    {
        getPeekStack().push(val);
    }
    
    public Stack<T> getPeekStack()
    {
        
        return stackOfStacks.peek();
    }
    
    public T pop() throws Exception
    {
        if(stackOfStacks.isEmpty())
            throw new Exception();
        
        if(peekStackSize() == 0)
        {
            popStack();
            if(stackOfStacks.isEmpty())
                throw new Exception();
        }
            
        return getPeekStack().pop();
    }
    
    public void popStack()
    {
        stackOfStacks.pop();
    }
    
    public int peekStackSize()
    {
        return stackOfStacks.peek().size();
    }
    
    public void pushStack()
    {
        Stack<T> newStack = new Stack();
        stackOfStacks.push(newStack);
    }
    
    

    
    
}
