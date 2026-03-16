package dp.level_9;

public class LC_1770_max_score_performing_multiplication_operations {
    int m; //max m operations allowed
    int n;
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        m=multipliers.length;
        n=nums.length;
        dp=new Integer[m+1][m+1]; // we need to eval till mth operation
        return solve(nums,multipliers,0,0);
    }

    private int solve(int[] nums, int[] multipliers,int op, int left){
        if(op==m) return 0; //all the m operations are completed.
        if(dp[left][op]!=null) return dp[left][op]; //memoization

        int right=n-1-op-left;

        int scoreLeft = multipliers[op]*nums[left]+solve(nums,multipliers,op+1,left+1);
        int scoreRight = multipliers[op]*nums[right]+solve(nums,multipliers,op+1,left);

        return dp[left][op]=Math.max(scoreLeft,scoreRight);
    }
}
