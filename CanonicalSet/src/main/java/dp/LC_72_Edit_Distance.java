package dp;

/**
 * m = word1.length
 * n = word2.length
 * compare char by char from w1 with w2
 * operations allowed INSERT, DELETE, REPLACE
 * case 1: if w1[i]==w2[j] => both characters are same so proceed to next char in both words
 * case 2: if w1[i]==w2[j] => characters not matched hence we can do either
 *   INSERT => INSERT in w1 to match with w2. so i in W1 will remain at same. Go next in W2 ( i, j++)
 *   DELETE => DELETE in W1 to match with w2. so j in W2 will be same. (i++, j)
 *   REPLACE => Compromise both and both proceed (i++,j++)
 *   All these operations are counted as counted. so we need to add 1+solve(....)
 *   Base Condition
 *   ---------------
 *   if(i==m && j==n) return 0; all the characters in both w1 & w2 are visited so no operation required
 *   if(i>=m) return n-j;
 *      w1 visited but w2 still has some chars. Chars remains from j to n.
 *      so we need to add these chars.
 *      ADD operation for (n-j)
 *   if(j>=n) return m-i;
 *      w2 visited, but w1 has m-i chars left. To delete these chars we need m-i operation
 */
public class LC_72_Edit_Distance {
    private int m;
    private int n;
    private Integer[][] dp;
    public int minDistance(String word1, String word2) {
        m= word1.length();
        n=word2.length();
        dp=new Integer[m+1][n+1];
        return solve(word1,word2,0,0);
    }

    private int solve(final String w1, final String w2, int i, int j){
        if(i==m && j==n) return 0;
        if(i>=m) return n-j;
        if(j>=n) return m-i;
        if(dp[i][j]!=null) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j]=solve(w1,w2,i+1,j+1);
        } else{
            int insert = 1+solve(w1,w2,i,j+1);
            int delete = 1+solve(w1,w2,i+1,j);
            int replace = 1+solve(w1,w2,i+1,j+1);
            return dp[i][j]=Math.min(insert, Math.min(delete,replace));
        }
    }
}
