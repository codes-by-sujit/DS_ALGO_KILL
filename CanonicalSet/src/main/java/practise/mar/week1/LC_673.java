package practise.mar.week1;

import org.junit.Test;

public class LC_673 {
    public int findNumberOfLIS(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max=Integer.MIN_VALUE;
        int counter=0;

        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(max<dp[i]){
                max=dp[i];
            }
        }
       for(int i=0;i<n;i++){
           if(max==dp[i]) counter+=count[i];
       }
        return counter;
    }

    @Test
    public void tc(){
        //int[] nums = new int[]{1,3,5,4,7};
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(this.findNumberOfLIS(nums));
    }
}
/**
 [1,3,5,4,7] count lis
 1->is a IS of length 1
 1,3-> len 2
 dp[i]=max(dp[j]+1mdp[i]
 at 5 compare with 1->5, 3->5

 count[i]-> tells the count of ways it reaches there for lis

 */
