package practise.feb.week4;

import org.junit.Test;

public class LC_416 {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=getSum(nums);
        if(sum%2!=0) return false;
        int partitionValue = sum/2;
        dp = new Boolean[nums.length][partitionValue+1];
        return isFound(nums,0,partitionValue);
    }

    private int getSum(int[] nums){
        int sum=0;
        for(int num:nums)
            sum+=num;
        return sum;
    }

    private boolean isFound(int[] nums, int index, int target){
        if(index==nums.length) return false;
        if(target<0) return false;
        if(target==0) return true;

        if(dp[index][target]!=null)
            return dp[index][target];

        boolean take = isFound(nums, index+1, target-nums[index]);
        boolean skip = isFound(nums, index+1, target);

        dp[index][target]=take||skip;
        return dp[index][target];
    }

    @Test
    public void tc(){
        //int[] nums = new int[]{1,5,11,5};
        int[] nums = new int[]{1,2,3,5};
        System.out.println(this.canPartition(nums));
    }
}

/**
 [1,5,11,5] sum=22
 partition 1 :11
sum of each subset ==11
 1
    take => solve(index++, target-num[i])
    or skip => solve(index++,target)

 return take || skip

 BC
    if(index==n) return true;
    if(target==0) return true ->  we considered exact subarray element
    if(target<0) return false;

 memoization
 changing param = index, target
 */
