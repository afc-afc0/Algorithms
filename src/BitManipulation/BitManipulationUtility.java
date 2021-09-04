package BitManipulation;

import java.util.Stack;

public class BitManipulationUtility {

    public static void printIntBinary(int num)
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

    public static void printFloatBinary(float f)
    {
    }

}
