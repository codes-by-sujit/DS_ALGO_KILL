package dp;

public class LC_516_Longest_Pallindromic_Subsequence {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp = new Integer[s.length()][s.length()];
        return this.solve(s,0,s.length()-1);
    }

    private int solve(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=null)
            return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=2+solve(s,i+1,j-1);
        } else{
            dp[i][j]=Math.max(solve(s,i+1,j), solve(s,i,j-1));
        }
        return dp[i][j];
    }
}
