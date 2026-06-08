class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);

        dp[0][1] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            for(int j=0;j<i+1;j++){
                dp[i][j+1] = Math.min(dp[i-1][j], dp[i-1][j+1])+triangle.get(i).get(j);
            }
        } 

        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            ans = Math.min(dp[n-1][i],ans);
        }
        return ans;
    }
}