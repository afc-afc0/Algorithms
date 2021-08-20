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
public class StackNode<T> {
    public T val;
    public StackNode<T> next;
    
    public StackNode(T val)
    {
        this.val = val;
    }
}


