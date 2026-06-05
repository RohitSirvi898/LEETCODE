class Solution {

    public int find(int[][] dp, int i, int j,int m,int n){
        if(i==m-1 && j==n-1) return 1;
        if(i==m || j==n) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        return dp[i][j] = find(dp, i+1,j,m,n)+find(dp,i,j+1,m,n);

    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = find(dp,0,0,m,n);
        return dp[0][0];
    }
}