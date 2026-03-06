package greedy.level_1;

import org.junit.Test;

public class LC_121_Buy_Sell_Stock {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;

        int maxProfit = Integer.MIN_VALUE;
        int i=0;
        for(int j=1;j<prices.length;j++){
            if(prices[i]>=prices[j]){
                i=j; continue;
            }
            maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
        }
        return maxProfit==Integer.MIN_VALUE?0:maxProfit;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(this.maxProfit(nums));
    }

}
