package dp;

/**
 * if chara matches then you have 2 choice
 * take the current char => i+1, j+1
 * skip character and wait for next match =>i,j+1
 *
 * if char not matched
 * move with the character i+1,j
 */
public class LC_115_Distinct_Subsequence {
    int m;
    int n;
    Integer [][] dp;
    public int numDistinct(String s, String t) {
        m=s.length();
        n=t.length();
        dp=new Integer[m+1][n+1];
        return solve(s,t,0,0);
    }
    private int solve(String s, String t, int i, int j){
        if(i==m && j==n) return 1;
        if(i==m) return 0;
        if(j==n) return 1; //match found
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(s,t,i+1,j+1)+solve(s,t,i+1,j);
        } else{
            return dp[i][j]= solve(s,t,i+1,j);
        }
    }
}
