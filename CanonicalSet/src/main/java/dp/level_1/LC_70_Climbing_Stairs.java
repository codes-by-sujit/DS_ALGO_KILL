package dp.level_1;

public class LC_70_Climbing_Stairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

/**
  at i you can reach from i-1 or i-2
 so dp[i]=dp[i-1]+dp[i-2]
 */
