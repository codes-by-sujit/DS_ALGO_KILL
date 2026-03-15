package prefix_sum.level_5;

import org.junit.Test;

public class LC_53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int currentSum=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            currentSum=Math.max(num, currentSum+num);
            max=Math.max(max, currentSum);
        }
        return max;
    }

    @Test
    public void tc(){
        int[] nums=new int[]{-2,1,-3,4-1,2,1,-5,4};
        System.out.println(this.maxSubArray(nums));
    }
}
