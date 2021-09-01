package BitManipulation;

        /*Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
        j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
        can assume that the bits j through i have enough space to fit all of M. That is, if
        M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
        example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.*/

import java.util.Stack;

public class Insertion
{
    int input1 = 36;
    int input2 = 3;

    public Insertion() {
        insertion(2,4);
    }

    public int insertion(int start, int end) {

        int allOnes = ~0;//11111111111...


        int left = allOnes << (end);
        int right = (1 << start) - 1;

        printIntBinary(left);
        printIntBinary(right);

        int mask = left | right;

        int result = mask & input2;
        input2 = input2 << start;

        return 0;
    }

    private void printIntBinary(int num)
    {
        int temp = 1;
        Stack<Boolean> s = new Stack<>();
        for(int i = 0;i < 32;i++) {
            if((temp & num) != 0)
                s.add(true);
            else
                s.add(false);
            temp <<= 1;
        }

        while(!s.isEmpty()) {
            boolean val = s.pop();
            if(val == true)
                System.out.print(1);
            else
                System.out.print(0);
        }
        System.out.println();

    }

}
