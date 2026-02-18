package dp;

import org.junit.Test;

import java.util.*;

public class LC_740_Delete_And_Earn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
            max=Math.max(max,num);
        }
        int[] dp = new int[max+1];
        for(int i=0;i<=max;i++){
            int prevScore = i-2>0?dp[i-2]:0;
            int scoreIfSkipped = i-1>0?dp[i-1]:0;
            int currScore=i*map.getOrDefault(i,0);
            dp[i]=Math.max(currScore+prevScore, scoreIfSkipped);
        }
        return dp[max];
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,1,1,2,4,5,5,5,6};
        System.out.println(this.deleteAndEarn(nums));
    }
}
