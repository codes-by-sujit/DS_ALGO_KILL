package practise;

import org.junit.Test;

public class LC_1143 {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return getLength(text1,text2,0,0);
    }

    private int getLength(String text1, String text2, int i, int j){
        if(i>=text1.length() || j>=text2.length())
            return 0;
        if(dp[i][j]!=null){
            return dp[i][j];
        }
         if(text1.charAt(i)==text2.charAt(j))
             dp[i][j]= 1+getLength(text1, text2, i+1,j+1);
         else{
             int opt1= getLength(text1,text2,i+1,j);
             int opt2= getLength(text1,text2,i,j+1);
             dp[i][j]= Math.max(opt1,opt2);
         }
         return dp[i][j];
    }

    @Test
    public void tc(){
        System.out.println(this.longestCommonSubsequence("abcde","ace"));
        System.out.println(this.longestCommonSubsequence("abc","abc"));
        System.out.println(this.longestCommonSubsequence("abc","def"));
    }
}
