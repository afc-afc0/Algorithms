package Algos;

public class MagicIndex {

    int[] input;

    public MagicIndex(){
        initInput();
        int result = magicIndex(input);
        System.out.println(result);
    }

    //Method to find a magic index if exists otherwise returns -1
    private int magicIndex(int[] input) {
        int left = 0;
        int right = input.length;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(mid == input[mid])
                return mid;

            if(mid > input[mid]){//go right
                left = mid;
            }
            else{//go left
                right = mid - 1;
            }
        }

        return -1;
    }

    private void initInput() {
        input = new int[]{-1,0,1,2,3,4,5,6,8};
    }

}
