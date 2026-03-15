package prefix_sum.level_5;

public class LC_918_Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int currentMaxSum=0;
        int currentMinSum=0;
        int total=0;
        for(int num:nums){
            total+= num;

            currentMaxSum=Math.max(currentMaxSum+num,num);
            maxSum=Math.max(maxSum,currentMaxSum);

            currentMinSum=Math.min(currentMinSum+num,num);
            minSum=Math.min(minSum, currentMinSum);
        }
        if(maxSum<0) return maxSum; // if maxSum is +ve then return maxSum
        else return total-minSum;
    }
}
/**
 max sum=total-min sum
 */
