package dp;

public class LC_416_Partition_Equal_subset_sum {

    //create a DP to store : at each weight is solution possible?
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        //calc total sum
        int sum=0;
        for(int num:nums)
            sum+=num;
        //if odd -> solution is not possible
        if(sum%2!=0) return false;

        //calc capacity of each partition
        int capacity=sum/2;

        dp = new Boolean[nums.length][capacity+1]; //we need to find till capacity wiz target

        return isPossible(nums, 0, capacity);
    }

    private boolean isPossible(int[] nums, int index, int leftOverWeight){
        //base condition
        if(leftOverWeight==0) return true;
        if(index>=nums.length || leftOverWeight<0) return false;

        //check from dp
        if(dp[index][leftOverWeight]!=null){
            return dp[index][leftOverWeight];
        }

        boolean take = isPossible(nums, index+1,leftOverWeight-nums[index]);
        boolean skip = isPossible(nums, index+1,leftOverWeight);
        dp[index][leftOverWeight]=take||skip;
        return dp[index][leftOverWeight];
    }
}
