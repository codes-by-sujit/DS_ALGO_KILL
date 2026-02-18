package dp;
// For max sum in linear array -> Kaden's
// for min sum in linear array -> kaden's
// in circular => totalsum-minsum = maxSum
// answer = max(linearmaxsum, circularmaxsum)

public class LC_918_Maximum_SUM_Circular_SubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int currentMaxSum=0;
        int currentMinSum=0;
        for(int num:nums){
            total+=num;

            currentMaxSum=Math.max(num,currentMaxSum+num);
            maxSum=Math.max(currentMaxSum,maxSum);

            currentMinSum=Math.min(num,currentMinSum+num);
            minSum=Math.min(minSum,currentMinSum);
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum, total-minSum);
    }
}
