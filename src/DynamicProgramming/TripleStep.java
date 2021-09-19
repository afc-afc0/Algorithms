package DynamicProgramming;

public class TripleStep {

    int input;

    public TripleStep(){
        System.out.println(tripleStep(5));
    }

    public int tripleStep(int n){

        int prev3 = 1, prev2 = 1, prev1 = 2;
        int result = -1;

        for (int i = 3; i <= n;i++){
            result = prev1 + prev2 + prev3;
            int temp = prev1;
            prev1 = result;
            prev3 = prev2;
            prev2 = temp;
        }

        return result;
    }

}
