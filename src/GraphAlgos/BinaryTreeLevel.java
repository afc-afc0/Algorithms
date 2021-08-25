/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ahmet
 */
public class BinaryTreeLevel {
    
    BinaryNode node;
    
    public BinaryTreeLevel()
    {
        buildTree();
    }
    
    private void buildTree()
    {
        BinaryNode root = new BinaryNode(1);        
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        
        root.left = node2;
        root.right = node3;
        
        node2.left = node4;
        node2.right = node5;
        
        node3.left = node6;
        
        ArrayList<LinkedList<Integer>> levels = new ArrayList();
        getLevels(root, levels, 0);
        
        for(int i = 0; i < levels.size();i++)
        {
            System.out.print("Level " + i + " = ");
            for(int j = 0; j < levels.get(i).size();j++)
                System.out.print(levels.get(i).get(j) + " ");
        }
        
    }
    
    private void getLevels(BinaryNode node, ArrayList<LinkedList<Integer>> result ,int level)
    {
        if(node == null)
            return;
        
        if(result.size() == level)//Create New level
        {
            result.add(new LinkedList<>());
            result.get(level).add(node.val);
        }
        else if(level < result.size())
        {
            result.get(level).add(node.val);    
        }
        
        getLevels(node.left, result, level + 1);
        getLevels(node.right, result, level + 1);
    }
    
    
}
