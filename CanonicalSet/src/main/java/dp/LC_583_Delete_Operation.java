package dp;

public class LC_583_Delete_Operation {
    private Integer[][] dp;
    private int m;
    private int n;
    public int minDistance(String word1, String word2) {
        dp=new Integer[word1.length()+1][word2.length()+1];
        m=word1.length();
        n=word2.length();
        return solve(word1,word2,0,0);
    }
    private int solve(String word1, String word2,int i, int j){
        if(i==m && j==n) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(i==m) return dp[i][j]=n-j;
        if(j==n) return dp[i][j]=m-i;
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=solve(word1,word2,i+1,j+1);
        } else{
            dp[i][j]=1+Math.min(solve(word1,word2, i+1,j), solve(word1,word2,i,j+1));
        }
        return dp[i][j];
    }
}
