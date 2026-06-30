class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        for(int i=n-1;i>=0;i--){
            dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);

        // dp[0] = helper(cost,0,dp);
        // dp[1] = helper(cost,1,dp);
        // return Math.min(dp[0],dp[1]);
    }

    public int helper(int[] cost, int i,int[] dp){
        if(i>=cost.length) return dp[i];
        if(dp[i]!=0) return dp[i];
        dp[i+1] = helper(cost,i+1,dp);
        dp[i+2] = helper(cost,i+2, dp);
        return dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
    }
}