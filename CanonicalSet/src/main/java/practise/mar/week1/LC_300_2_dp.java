package practise.mar.week1;

public class LC_300_2_dp {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[nums.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        for(int num:dp){
            max=Math.max(num,max);
        }
        return max;
    }
}
/**
 [1,2,5,3,6]
 the num itself a IS
 dp[i]=Math.max(dp[j+1], dp[i])
 */