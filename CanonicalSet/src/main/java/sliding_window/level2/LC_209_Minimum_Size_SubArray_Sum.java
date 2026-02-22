package sliding_window.level2;

import org.junit.Test;

public class LC_209_Minimum_Size_SubArray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        for(;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target){
                minLen=Integer.min(minLen, (j-i)+1);
                sum-=nums[i];
                i++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(this.minSubArrayLen(target, nums));

    }
}
