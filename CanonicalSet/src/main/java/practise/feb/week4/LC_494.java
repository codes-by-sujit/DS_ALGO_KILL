package practise.feb.week4;

import org.junit.Test;

public class LC_494 {
    Integer[][] dp;
    int MAX = 1000;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][2001];
        return count(nums,target,0,0);
    }
    private int count(int[] nums, int target, int index, int sum){
       if(index==nums.length && sum==target) return 1;
       if(index==nums.length) return 0;

       if(dp[index][MAX+sum]!=null)
            return dp[index][MAX+sum];

        int posSum = count(nums, target, index+1, sum+nums[index]);
        int negSum = count(nums, target, index+1, sum-nums[index]);

        dp[index][MAX+sum]= posSum+negSum;
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
 [2,1] target=1

 2
    +2 => posSum => solve(index+1,sum+nums[i])
   -2  => negSum => solve(index+1,sum-nums[i])
 return posSum+negSum

 BC
 index==nums.length return 0;
 sum==target return 1;
 sum>target return 0

 memoization
 cp: 2 => index, sum
    dp[nums.length][target+1]

 3
 -3,-2,-1,0,1,2,3
 0,  1, 2,3,4,5,6,7

 -2 -3
 target+sum = 1
 3

 */
