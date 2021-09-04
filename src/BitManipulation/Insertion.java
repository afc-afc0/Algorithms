package BitManipulation;

        /*Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
        j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
        can assume that the bits j through i have enough space to fit all of M. That is, if
        M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
        example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.*/

public class Insertion
{
    int input1 = 41;
    int input2 = 10;

    public Insertion() {
        System.out.println(insertion(1,4));
    }

    public int insertion(int start, int end) {

        int cleared = clearBitsBetween(input1, start, end);
        int shifted = shiftBits(input2, start);

        return cleared | shifted;
    }

    private int shiftBits(int num, int count)
    {
        num = num << count;
        return num;
    }

    private int clearBitsBetween(int num, int start, int finish)
    {
        int mask = 1;

        int i = 0;
        while(i < start)
        {
            mask <<= 1;
            i++;
        }

        while(i < finish)
        {
            if((mask & num) != 0)//We need to clear the bit
                num -= mask;

            mask <<= 1;
            i++;
        }

        return num;
    }



}
