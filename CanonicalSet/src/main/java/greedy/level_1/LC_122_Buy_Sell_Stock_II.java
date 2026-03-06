package greedy.level_1;

public class LC_122_Buy_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;

        int profit=0;
        for(int j=1;j<n;j++){
            profit+=Math.max(0,prices[j]-prices[j-1]);
        }
        return profit;
    }
}
