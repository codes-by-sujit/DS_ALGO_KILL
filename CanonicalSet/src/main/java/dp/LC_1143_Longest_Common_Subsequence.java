package dp;

public class LC_1143_Longest_Common_Subsequence {
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                } else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    private Integer[][] dp;
    private int m;
    private int n;

    public int longestCommonSubsequence(String text1, String text2) {
        m=text1.length();
        n=text2.length();
        dp=new Integer[m+1][n+1];
        return solve(text1,text2,0,0);
    }
    private int solve(String s,String t,int i,int j){
        if(i>=m || j>=n) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j]=1+solve(s,t,i+1,j+1);
        else{
            return dp[i][j]=Math.max(solve(s,t,i+1,j),solve(s,t,i,j+1));
        }
    }
}
