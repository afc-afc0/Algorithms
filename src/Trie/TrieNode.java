/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

/**
 *
 * @author ahmet
 */
public class TrieNode {
    
    int alphabetSize;
    public boolean end;
    public TrieNode[] nodes;
    
    public TrieNode(int alphabetSize)
    {
        this.alphabetSize = alphabetSize;
        this.end = false;
        this.nodes = new TrieNode[alphabetSize];
        for(int i = 0; i < alphabetSize;i++)
        {
            nodes[i] = null;
        }
    }
}
