package dp;

public class LC_322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        // dp to store: at each target i what is min possible ways to achieve.
        int[] dp = new int[amount+1];

        dp[0]=0; // for 0 amount no need to pick any coins
        //check the possibilities for each amount
        for(int i=1;i<=amount;i++){
            //setup current position to very high, if no solution feasible it should return like that
            dp[i]=Integer.MAX_VALUE;
            //check for each coin
            for(int coin:coins){
                if(
                    coin<=i  &&//coin must be <=target
                    dp[i-coin]!=Integer.MAX_VALUE //left over amount must have possibility
                ){
                    //check if I go with this coin will I get achieve target in min  value or
                    // should I go with prev value
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

}
