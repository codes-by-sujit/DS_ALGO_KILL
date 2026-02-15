package dp;

public class LC_Unique_Paths_II {
    private Integer[][] dp;
    private int m;
    private int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        dp=new Integer[m+1][n+1];
        return solve(obstacleGrid,0,0);
    }
    private int solve(int[][] grid,int i, int j){
        if(i>=m || j>=n || grid[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;

        if(dp[i][j]!=null) return dp[i][j];
        int rightSoln = solve(grid,i,j+1);
        int bottomSoln = solve(grid,i+1,j);
        return dp[i][j]=rightSoln+bottomSoln;
    }
}
