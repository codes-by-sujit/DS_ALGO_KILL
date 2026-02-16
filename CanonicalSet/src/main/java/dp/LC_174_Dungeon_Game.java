package dp;

public class LC_174_Dungeon_Game {
    Integer[][] dp;
    int m;
    int n;
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        dp=new Integer[m][n];
        return solve(dungeon,0,0);
    }

    private int solve(int[][] grid,int i,int j){
        if(i>=m || j>=n) return Integer.MAX_VALUE; //It's exhausted so return a high number
        if(dp[i][j]!=null) return dp[i][j];
        //if it's a princess cell
        if(i==m-1 && j==n-1){
            return dp[i][j]=grid[i][j]<=0?Math.abs(grid[i][j])+1:1;
        } else{ //for other cell
            int val = grid[i][j];
            int minRightHP = solve(grid,i,j+1);
            int minBottomHP = solve(grid,i+1,j);
            int nextHP = Math.min(minBottomHP,minRightHP);
            int currentHP = Math.max(1,nextHP-val);
            return dp[i][j]=currentHP;
        }
    }
}
