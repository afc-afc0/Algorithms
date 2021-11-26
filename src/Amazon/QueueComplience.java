package Amazon;

public class QueueComplience{

    public QueueComplience() {
        int[] input = new int[]{1,4,8,4};
        int[] result = calculateQueue(input);

        System.out.println("Result >>>>>>>>>>>>>>>>>");
        for (int num : result)
            System.out.print(num + " ");
    }

    private int[] calculateQueue(int[] nums){
        
        int[] count = new int[100];
        for (int num : nums)
            count[num]++;


        int queueNum = 1;
        for (int i = 1;i <= 99;i++)
            if (count[i] != 0)
                count[i] = queueNum++;
            
        int[] result = new int[nums.length];
        for (int i = 0;i < nums.length; i++)
            result[i] = count[nums[i]];
        
        return result;
    }
}