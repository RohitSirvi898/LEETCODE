class Solution {
    long dp[][];
    public long helper(int[] nums,int positive, int n, int i){
        if(i==n) return 0;
        if(dp[i][positive]!=-1) return dp[i][positive];
        long take = 0;
        if(positive==0) take = nums[i] + helper(nums,1,n,i+1);
        else take = -nums[i] + helper(nums,0,n,i+1);
        long notTake = helper(nums,positive,n,i+1);
        return dp[i][positive] = Math.max(take,notTake);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        return helper(nums,0,n,0);
    }
}