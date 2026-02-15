package dp;

public class LC_64_Min_Path_Sum {
    private Integer[][] dp;
    private int m;
    private int n;

    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new Integer[m][n];
        return solve(grid,0,0);
    }

    private int solve(int[][] grid, int i, int j){
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(dp[i][j]!=null) return dp[i][j];
        int current=grid[i][j];
        int rightSum=solve(grid,i,j+1);
        int bottomSum=solve(grid,i+1,j);
        int min = Math.min(rightSum,bottomSum);
        return dp[i][j]=min==Integer.MAX_VALUE?min:min+current;
    }
}
