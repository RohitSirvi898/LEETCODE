class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for(int num:nums){
            long[] nextDp = new long[k];
            int x = num%k;
            nextDp[x]++;
            for(int r=0;r<k;r++){
                if(dp[r]>0){
                    nextDp[(r*x)%k] += dp[r];
                }
            }

            for(int r=0;r<k;r++){
                result[r]+=nextDp[r];
                dp[r] = nextDp[r];
            }
        }

        return result;
    }
}