package practise.feb.week4;

import org.junit.Test;

public class LC_322 {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new Integer[coins.length][amount+1];
        return count(coins,amount,0);
    }

    public int count(int[] coins,int leftAmount, int index){
        if(leftAmount==0) return 0;
        if(leftAmount<0) return Integer.MAX_VALUE;
        if(index==coins.length) return Integer.MAX_VALUE;

        if(dp[index][leftAmount]!=null) return dp[index][leftAmount];

        int take = count(coins,leftAmount-coins[index],index);
        int skip = count(coins,leftAmount,index+1);
       if(take!=Integer.MAX_VALUE) take+=1;
        dp[index][leftAmount]=Math.min(take,skip);
        return dp[index][leftAmount];
    }

    @Test
    public void tc(){
        int[] nums=new int[]{1,2,5};
        System.out.println(this.coinChange(nums,11));
    }
}
/**
 [1,2,5] t=11

 1->take/skip
    1+index,t-num
    index+1,t
 bc
 if(t==0) return 0
 if(t<0) return 0
 index==n return 0
 */
