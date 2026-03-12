package dp.level_6;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

public class LC_312_Burst_Ballons {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        int index=1;
        for(int n: nums){
            arr[index++]=n;
        }
        dp=new Integer[nums.length+2][nums.length+2];
        return solve(arr,1, nums.length);
    }

    private int solve(int[] nums, int i, int j){
        if(i>j) return 0;
        int max=Integer.MIN_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        for(int k=i;k<=j;k++){
            int left=solve(nums, i, k-1);
            int right=solve(nums,k+1,j);
            int curr=nums[i-1]*nums[k]*nums[j+1];
            max= Math.max(max, left+curr+right);
        }
        return dp[i][j]=max;
    }

    @Test
    public void tc(){
        System.out.println(this.maxCoins(new int[]{3,1,5,8}));
    }
}
