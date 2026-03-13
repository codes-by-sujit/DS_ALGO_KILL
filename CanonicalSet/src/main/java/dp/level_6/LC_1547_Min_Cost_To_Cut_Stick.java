package dp.level_6;

import java.util.Arrays;

public class LC_1547_Min_Cost_To_Cut_Stick {
    Integer[][] dp;
    public int minCost(int n, int[] cuts) {
        int[] temp=new int[cuts.length+2];
        dp = new Integer[cuts.length+2][cuts.length+2];
        temp[0]=0;
        temp[temp.length-1]=n;
        int index=1;
        for(int num:cuts){
            temp[index++]=num;
        }
        Arrays.sort(temp);
        return solve(temp,0,temp.length-1);
    }

    private int solve(int[] cuts,int i, int j){ //the segment from i->j
        if(j-i<=1) return 0; //no cuts required
        if(dp[i][j]!=null) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int currCost=cuts[j]-cuts[i];
            int minCostleft=solve(cuts,i,k);
            int minCostright=solve(cuts,k,j);
            int totalCost = currCost+minCostleft+minCostright;
            min=Math.min(min,totalCost);
        }
        return dp[i][j]=min;
    }
}
