package dp.level_6;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_132_Palindrome_Partitioning_II {
    Integer[] dp;
    Boolean[][] palliDp;
    public int minCut(String s) {
        dp=new Integer[s.length()];
        palliDp=new Boolean[s.length()][s.length()];
        return solve(s,0)-1;
    }

    private int solve(String s, int index){
        if(index==s.length()) return 0;
        if(dp[index]!=null) return dp[index];
        int min=Integer.MAX_VALUE;
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                min=Math.min(min, 1+solve(s,i+1));
            }
        }
        return dp[index]=min;
    }

    private boolean isPalindrome(String s,int i, int j){
        if(palliDp[i][j]!=null) return palliDp[i][j];
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return palliDp[i][j]=false;
            }
            i++;
            j--;
        }
        return palliDp[i][j]=true;
    }

    @Test
    public void tc(){
        String s = "aab";
        System.out.println(this.minCut(s));
    }
}
