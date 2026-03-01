package practise.mar.week1;

public class LC_300 {

    public int lengthOfLIS(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        int max = Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
/**
 [1,5,3,6] 1,5,6 1,3,6
 i: LIS ending at i
 num[i] itself an IS

 1 -> IS =1
 1,5 at 5 IS 1, at 1 IS 1 so at 5 IS = 1+1 = 2

 */
