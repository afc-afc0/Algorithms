package DFSAlgos;

import java.util.ArrayList;

public class GetSubseqsOfString {
    

    public GetSubseqsOfString() 
    {
        String input = "abc"; 
        ArrayList<String> result = subsequences(input);    
        printArrayList(result); 
    }

    private ArrayList<String> subsequences(String str) 
    {
        ArrayList<String> result = new ArrayList<>();
        helper(str, new StringBuilder(), 0, result);

        return result;
    }

    private void helper(String str, StringBuilder path, int index, ArrayList<String> result)
    {
        if (index == str.length())
        {
            result.add(path.toString());
            return;
        }

        int len = path.length();
        helper(str, path.append(str.charAt(index)), index + 1, result);
        path.setLength(len);
        helper(str, path, index + 1, result);
    }

    private void printArrayList(ArrayList<String> result)
    {
        System.out.println("Printing subseqs");
        for (String s : result)
            System.out.println(s);
    }

}
