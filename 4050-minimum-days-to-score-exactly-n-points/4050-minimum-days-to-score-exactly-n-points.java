class Solution {
    public int minDays(int n) {
        int[] dp = new int[n+1];

        Arrays.fill(dp,1000000000);
        dp[0] = 0;
        for(int l=1;;l++){
            int total = l*(l+1)/2;
            if(total>n) break;
            int cost = l+1;
            for(int j=total;j<=n;j++){
                if(dp[j-total]+cost<dp[j]){
                    dp[j] = dp[j-total]+cost;
                }
            }
        }

        return dp[n]-1;
    }
}