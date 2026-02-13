package dp;

public class LC_879_Profitable_Schema {
    private Integer[][][] dp;
    private static final int MOD = 1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[group.length][minProfit+1][n+1];
        return getCount(group,profit,n,minProfit,0,0,0);
    }

    private int getCount(int[] group, int[] profit, int n, int minProfit, int currentProfit, int currentPeopleCount, int index){
        if(currentPeopleCount>n)
            return 0;

        if(index==group.length){
            if(currentProfit>=minProfit)
                return 1;
            else
                return 0;
        }

        if(dp[index][currentProfit][currentPeopleCount]!=null)
            return dp[index][currentProfit][currentPeopleCount];
        int skip = getCount(group, profit,n,minProfit, currentProfit, currentPeopleCount, index+1);
        int tempProfit = currentProfit+profit[index];
        tempProfit = Math.min(tempProfit, minProfit);
        int tempPeopleCount = currentPeopleCount + group[index];
        int take = getCount(group, profit,n,minProfit, tempProfit, tempPeopleCount, index+1);
        dp[index][currentProfit][currentPeopleCount] = (skip+take)%MOD;
        return dp[index][currentProfit][currentPeopleCount];
    }
}
