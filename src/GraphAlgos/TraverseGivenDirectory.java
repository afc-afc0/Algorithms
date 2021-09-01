    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgos;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ahmet
 */
public class TraverseGivenDirectory {
    
    
    public TraverseGivenDirectory(String dir)
    {
        File root = new File(dir);
        
        ArrayList<String> res = getAllFilesFromDirectory(root);
    }
    
    //C:\Users\ahmet\Desktop\Classes
    
    public TraverseGivenDirectory()
    {
        File root = new File("C:/Users/ahmet/Desktop/a");
        ArrayList<String> res = getAllFilesFromDirectory(root);
        
        for(String str : res)
            System.out.println(str);
    }
    
    private ArrayList<String> getAllFilesFromDirectory(File root)
    {
        ArrayList<String> result = new ArrayList();
        if(!root.exists())
            return result;
       
        DFS(root, result);
        
        return result;
    }
    
    private void DFS(File currentDir, ArrayList<String> result)
    {
        if(currentDir == null)
            return;
        
        File[] files = currentDir.listFiles();
        
        result.add(currentDir.getName());        
                
        for(File file : files)
            DFS(file, result);
    }
}
