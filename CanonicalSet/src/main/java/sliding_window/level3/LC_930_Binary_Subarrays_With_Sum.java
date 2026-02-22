package sliding_window.level3;

import org.junit.Test;

public class LC_930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0)
            return atMost(nums,0);
        else
            return atMost(nums,goal)-atMost(nums,goal-1);
    }
    private int atMost(int[] nums, int k){
        int i=0;
        int j=0;
        int sum=0;
        int counter =0;
        for(;j<nums.length;j++){
            sum+=nums[j];
            while(sum>k){
                int left=nums[i];
                sum-=left;
                i++;
            }
            counter+=(j-i)+1;
        }
        return counter;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(this.numSubarraysWithSum(nums,2));
    }
    @Test
    public void tc2(){
        int[] nums = new int[]{0,0,0,0,0};
        System.out.println(this.numSubarraysWithSum(nums,0));
    }
}
