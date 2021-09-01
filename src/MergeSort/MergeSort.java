package MergeSort;

import java.util.Arrays;

public class MergeSort
{

    int[] input;

    public MergeSort()
    {
        initInput();
        int[] auxArr = Arrays.copyOf(input, input.length);
        mergeSort(input, auxArr,0, input.length);
    }

    private void mergeSort(int[] arr, int[] aux, int left, int right) {

        if(left == right)
            return;
        //Divide

        int mid = left + (right - left) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);

        merge(arr, aux, left, mid, right);
    }

    private void merge(int[] arr, int[] aux, int left, int mid, int right)
    {
        int insertPos = left;

        while(left <= mid && mid < right)
        {
            if(arr[left] < arr[right])
            {
                aux[insertPos] = arr[left];
                left++;
            }
            else
            {
                aux[insertPos] = arr[right];
                right--;
            }
        }





    }

    private void initInput() {
        input = new int[]{38,27,43,3,9,82,10};
    }


}
