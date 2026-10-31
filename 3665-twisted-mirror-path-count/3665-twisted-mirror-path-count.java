class Solution {
    long[][][] dp;
    int mod = 1000000007;
    int n,m;
    public long dfs(int[][] grid, int i, int j, int dir){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j][dir]!=-1) return dp[i][j][dir];

        if(grid[i][j]==1){
            if(dir==0) dp[i][j][dir] = dfs(grid,i+1,j,1);
            else dp[i][j][dir] = dfs(grid,i,j+1,0);
        }
        else dp[i][j][dir] = (dfs(grid, i, j+1, 0) + dfs(grid, i+1, j, 1)) % mod;

        return dp[i][j][dir];
    } 
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new long[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return (int)dfs(grid,0,0,0);
    }
}