/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterview;

import static Chapter1.Chapter1Questions.isPermutation;
import static Chapter1.Chapter1Questions.isPermutationPalindrome;
import static Chapter1.Chapter1Questions.oneAway;
import static Chapter1.Chapter1Questions.stringCompression;
import DFSAlgos.CountIslands;
import DFSAlgos.TransitiveClosureMatrix;
import static GraphAlgos.BellmanFord.BellmanFord;
import GraphAlgos.BinaryTreeLevel;
import static GraphAlgos.BreadthFirstSearch.BFS;
import GraphAlgos.CheckBalanced;
import GraphAlgos.FloydWarshall;
import static GraphAlgos.FloydWarshall.findAPSP;
import GraphAlgos.GraphNode;
import GraphAlgos.MinimalEdge;
import LinkedList.ListNode;
import LinkedList.ListUtilityFunctions;
import static LinkedList.ListUtilityFunctions.printList;
import static LinkedList.Questions.addTwoLists;
import static LinkedList.Questions.intersectionBegin;
import static LinkedList.Questions.isPalindrome;
import static LinkedList.Questions.removeDups;
import static LinkedList.Questions.partition;
import StackAndQueues.Queue;
import StackAndQueues.StackMin.StackMin;
import StackAndQueues.StackMin.StackMinNode;
import StackAndQueues.StackNode;
import StackAndQueues.StackOfStacks.StackOfStacks;
import StackAndQueues.StackSort;
import java.util.ArrayList;
import java.util.Stack;
import Graphs.*;
import static GraphAlgos.DepthFirstSearch.DFS;
import GraphAlgos.Eulerian;
import GraphAlgos.KasajarasFindSCC;
import GraphAlgos.MinimalTree;
import GraphAlgos.ReverseGraph;
import GraphAlgos.RouteBetweenNodes;
import Trie.Trie;

/**
 *
 * @author ahmet
 */
public class CrackingTheCodingInterview {

    //    3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

    public static void main(String[] args) throws Exception {
        Eulerian eu = new Eulerian(); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static Stack<Integer> sortStack(Stack<Integer> stack)
    {
        if(stack.size() == 1)
        {
            System.out.println("here");
            return stack;
        }

        //Divide
        Stack<Integer> left = new Stack();
        Stack<Integer> right = new Stack();
        
        for(int i = 0; i < stack.size() / 2;i++)
            right.push(stack.pop());

        while(!stack.isEmpty())
            left.push(stack.pop());

        
        //conqueror
        return merge(left, right);
    }
    
    public static Stack<Integer> merge(Stack<Integer> left, Stack<Integer> right)
    {
        Stack<Integer> result = new Stack();

        while(!left.isEmpty() || !right.isEmpty())
        {            
            if(!left.isEmpty() && !right.isEmpty())
            {
                int peekLeft = left.peek();
                int peekRight = right.peek();
                result.push(peekLeft > peekRight ? left.pop() : right.pop());
            }
            else if(left.isEmpty() && !right.isEmpty())
                result.push(right.pop());
            else
                result.push(left.pop());
        }
        
        return result;
    }
    
   
    

    
}
