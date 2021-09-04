package Algos;

import java.util.ArrayList;

public class WordCombinations {

    private int[] input;

    public WordCombinations(){
        input = new int[]{1,2,2,1};

        ArrayList<String> result = new ArrayList<>();
        getWordCombinations(input, 0, "", result);

        for (String str : result)
            System.out.println(str);
    }

    private void getWordCombinations(int[] input, int i, String path, ArrayList<String> result)
    {
        if(i == input.length)
        {
            result.add(path);
            return;
        }

        int sum = 0;

        for(int j = i; j <= Math.min(i + 1, input.length - 1);j++)
        {
            sum = (sum * 10) + input[j];

            if(sum > 0 && sum <= 26)
            {
                getWordCombinations(input, j + 1,path + (char)(sum + 'A' - 1), result);
            }
        }
    }

}
