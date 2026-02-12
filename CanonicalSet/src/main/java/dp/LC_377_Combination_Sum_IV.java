package dp;

public class LC_377_Combination_Sum_IV {
    Integer[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1];
        return solve(nums,target);
    }

    private int solve(int[] nums, int left){
        if(left==0) return 1;
        if(left<0) return 0;
        if(dp[left]!=null) return dp[left];
        dp[left]=0;
        for(int num:nums){
            dp[left]+=solve(nums,left-num);
        }
        return dp[left];
    }
}
