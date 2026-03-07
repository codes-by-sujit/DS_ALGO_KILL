package sliding_window.level_1;

import org.junit.Test;

public class LC_643_max_avg_subarray {
    public double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        int sum=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while((j-i)+1>k){
                sum-=nums[i];
                i++;
            }
            if((j-i)+1==k){
                max=Math.max(max,(double)sum/k);
            }
        }
        return max;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{-1};
        System.out.println(this.findMaxAverage(nums,1));
    }
}
