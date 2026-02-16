package dp;

public class LC_1463_Cherry_Pickup_II {
    Integer[][][] dp;
    int m;
    int n;
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n=grid[0].length;
        dp=new Integer[m][n][n];
        return solve(grid,0,0,n-1);
    }

    private int solve(int[][] grid, int row, int col1, int col2){
        if(row==m) return 0;
        if(dp[row][col1][col2]!=null) return dp[row][col1][col2];
        //cherry collected at current row
        int cherry = grid[row][col1]; //picked by Robot1
        if(col1!=col2)
            cherry+= grid[row][col2]; //if not same cherry then it can be picked by robot 2
        // Cherry collection on next row
        // The robot can go only diag-left-down, down, diag-right-down

        int ans = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nextRow = row+1;
                int nextCol1 = col1+i;
                int nextCol2 = col2+j;
                //Go if the direction is valid
                if(
                        nextCol1 >= 0 && nextCol1 < n &&
                        nextCol2 >= 0 && nextCol2 < n
                ) {
                    ans = Math.max(ans,solve(grid,nextRow,nextCol1,nextCol2));
                }
            }
        }
        return dp[row][col1][col2] = ans+cherry;
    }
}
