class Solution {
    int[][] dp;
    public int dfs(int i, int j, int[][] grid,int n){
        if(i>=n || j<0 || j>=n) return Integer.MAX_VALUE;
        if(i==n-1) return grid[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        return dp[i][j] =  grid[i][j] + Math.min(dfs(i+1,j-1,grid,n),Math.min(dfs(i+1,j,grid,n),dfs(i+1,j+1,grid,n)));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,dfs( 0, i, matrix,n));
        }
        return min;
    }
}