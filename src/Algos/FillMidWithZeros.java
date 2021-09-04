package Algos;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class FillMidWithZeros {

    // [0,1,2,0,0,0,3,4,0,5,6,7,8]

    int[] input;

    public FillMidWithZeros(){
        input = new int[]{0,1,2,0,0,0,3,4,0,5,6,7,8,1,2,3,4,5,0,0,67};
        Deque<Integer> result = run(input);
        printDeque(result);
    }

    private void printDeque(Deque<Integer> deq)
    {
        System.out.println("printing result");
        for (int num : deq)
        {
            System.out.print(num + " ");
        }
    }

    private Deque<Integer> run(int[] input) {
        Deque<Integer> result = new LinkedList<>();

        int zeroCount = 0;
        for(int i = 0; i < input.length;i++)
            if(input[i] == 0)
                zeroCount++;

        //First fill Middle With Zeros
        for (int i = 0; i < zeroCount;i++)
            result.offer(0);


        int insertIndex = 0;
        Stack<Integer> left = new Stack<>();
        int mid = (input.length - zeroCount) / 2;
        for(int i = 0; i < input.length;i++)
        {
            int val = input[i];
            if(val != 0)
            {
                if(insertIndex < mid)
                {
                    left.push(val);
                    insertIndex++;
                }
                else
                {
                    result.offerLast(val);
                }
            }
        }

        while(!left.isEmpty())
            result.offerFirst(left.pop());

        return result;
    }




}
