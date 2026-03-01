package practise.mar.week1;

import org.junit.Test;

public class LC_494 {
    private static int MAX=1000;
    private Integer[][] dp;
    private int n;

    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        dp=new Integer[n][MAX*2+1];
        return count(nums, target, 0,0);
    }

    private int count(int[] nums, int target, int sum, int index){
        if(index==n && target==sum) return 1;
        if(index==n) return 0;
        if(dp[index][MAX+sum]!=null) return dp[index][MAX+sum];
        int posSum = count(nums, target,sum+nums[index],index+1);
        int negSum = count(nums, target,sum-nums[index],index+1);
        dp[index][MAX+sum] = posSum+negSum;
        return dp[index][MAX+sum];
    }

    @Test
    public void tc(){
        int[] nums = new int[] {1,1,1,1,1};
        //int[] nums = new int[] {2,1};
        System.out.println(this.findTargetSumWays(nums,3));
    }
}

/**
 [1,1,1] t=3

 1-> posSum +1 ->count of ways if pos
        solve(index+1, sum+num)
     negSum -1 ->count of ways if neg
        solve(index+1, sum+num)
 return posSum+negSum

 bc
 if(target==sum) return 1
 if(index==n) return 0



 */
