/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

import java.util.ArrayList;

/**
 *
 * @author ahmet
 */

//!!! Think after learning the HashMap in university I think about a structure like this for searching this is 
// that data structure


//Trie is an efficient information reTrieval data structure.
//Using Trie, search complexities can be brought to optimal limit (key length). 
//If we store keys in binary search tree, a well balanced BST will need time 
//proportional to M * log N, where M is maximum string length and N is number of keys in tree.
//Using Trie, we can search the key in O(M) time. However the penalty is on Trie storage requirements

public class Trie {
    
    public TrieNode root;
    public int alphabetSize;
    
    
    public Trie(int alphabetSize)
    {
        this.alphabetSize = alphabetSize; 
        root = new TrieNode(alphabetSize);
    }
    
    public void insert(String word)
    {
        //Assume we only have lower case characters!!!
        
        TrieNode currentNode = root;
        
        for(int i = 0; i < word.length();i++){
            
            int key = word.charAt(i) - 'a';
            if(currentNode.nodes[key] != null)
                currentNode = currentNode.nodes[key];
            else
            {
                currentNode.nodes[key] = new TrieNode(alphabetSize);
                currentNode = currentNode.nodes[key];
                i++;
                while(i < word.length())
                {
                    key = word.charAt(i) - 'a';
                    currentNode.nodes[key] = new TrieNode(alphabetSize);
                    currentNode = currentNode.nodes[key];
                    i++;
                }
            }
        }
    }
    
    
    public boolean find(String word)
    {
        TrieNode currentNode = root;
        
        for(int i = 0; i < word.length();i++)
        {
            int key = word.charAt(i) - 'a';
            if(currentNode.nodes[key] == null)
                return false;
            
            currentNode = currentNode.nodes[key];
        }
        
        return true;
    }
    
    public ArrayList<String> autoComplete(String word)
    {
        TrieNode currentNode = root;
        ArrayList<String> result = new ArrayList();
        
        StringBuilder sb = new StringBuilder();
        //First get the right node for start
        for(int i = 0;i < word.length();i++)
        {
            int key = word.charAt(i) - 'a';
            if(currentNode.nodes[key] == null)
                return result;
            
            currentNode = currentNode.nodes[key];
            sb.append(word.charAt(i));
        }
        
      
        for(int i = 0; i < alphabetSize;i++)
        {
            if(currentNode.nodes[i] != null)
            {
                char ch = (char) (i + 'a');
                helper(currentNode.nodes[i], i, result, sb);
            }
        }
        
        
        return result;
    }
    
    private void helper(TrieNode node, int key, ArrayList<String> result, StringBuilder sb)
    {
        if(node == null)
            return;
        
        char ch = (char) (key + 'a');
        sb.append(ch);
        
        boolean allNull = true;
        for(int i = 0; i < alphabetSize; i++)
        {
            if(node.nodes[i] != null)
            {
                allNull = false;
                helper(node.nodes[i], i, result, sb);
            }
                
            if(i == alphabetSize - 1 && allNull == true)
                result.add(sb.toString());
        }
    }
    
    
}
