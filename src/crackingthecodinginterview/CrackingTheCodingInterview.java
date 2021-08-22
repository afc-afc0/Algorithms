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
import static GraphAlgos.BreadthFirstSearch.BFS;
import GraphAlgos.GraphNode;
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


/**
 *
 * @author ahmet
 */
public class CrackingTheCodingInterview {

    //    3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

    public static void main(String[] args) throws Exception {
        
        Graph graph = new Graph();
        
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        
        A.addEdge(new Edge(A,B,10));
        A.addEdge(new Edge(A,E,3));
        B.addEdge(new Edge(B,C,2));
        B.addEdge(new Edge(B,E,4));
        E.addEdge(new Edge(E,B,1));
        E.addEdge(new Edge(E,D,2));
        C.addEdge(new Edge(C,D,9));
        D.addEdge(new Edge(D,C,7));
        
        graph.dijkstra(A);
        
        graph.nodes.add(A);
        graph.nodes.add(B);
        graph.nodes.add(C);
        graph.nodes.add(D);
        graph.nodes.add(E);
        
        for(Node n : graph.nodes)
            System.out.println("Name : " + n.name + ", Weight : " + n.weight);
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
