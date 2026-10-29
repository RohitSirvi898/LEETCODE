class Solution {
    int[][] dp;
    public int dfs(int i, int j, int[][] grid){
        if(i<0 || j<0) return 0;
        if(grid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = dfs(i-1,j,grid) + dfs(i,j-1,grid);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return dfs(m-1,n-1,obstacleGrid);
    }
}