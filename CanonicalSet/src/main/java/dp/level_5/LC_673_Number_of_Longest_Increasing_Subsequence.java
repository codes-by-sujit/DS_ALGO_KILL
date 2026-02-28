package dp.level_5;

import org.junit.Test;

public class LC_673_Number_of_Longest_Increasing_Subsequence {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max=Integer.MIN_VALUE;
        int counter = 0;
        for(int i=0;i<n;i++){
            dp[i]=1; //the current element can be a subsequence of length 1
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) {
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    } else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        for(int i=0;i<n;i++){
            if(dp[i]==max) counter+=count[i];
        }
        return counter;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(this.findNumberOfLIS(nums));
    }
    @Test
    public void tc2(){
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(this.findNumberOfLIS(nums));
    }

}
