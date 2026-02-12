package dp;

public class LC_518_Coin_Change_II {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[amount+1][coins.length];
        return getPossibleWays(coins,amount,0);
    }

    private int getPossibleWays(int[] coins,int amountLeft, int index){
        if(amountLeft==0) return 1;
        if(index>=coins.length || amountLeft<0) return 0;
        if(dp[amountLeft][index]!=null) return dp[amountLeft][index];

        int take = getPossibleWays(coins, amountLeft-coins[index],index);
        int skip= getPossibleWays(coins,amountLeft,index+1);

        dp[amountLeft][index]= take+skip;

        return dp[amountLeft][index];
    }
}
