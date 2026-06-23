class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1000000007;
        int m = r-l+1;
        int[] dp = new int[m];
        Arrays.fill(dp,1);

        for(int i=2;i<=n;i++){
            int sum=0;
            if((i&1)==0){
                for(int j=0;j<m;j++){
                    int t = dp[j];
                    dp[j] = sum;
                    sum = (sum+t)%mod;
                }
            }
            else{
                for(int j=m-1;j>=0;j--){
                    int t = dp[j];
                    dp[j] = sum;
                    sum = (sum+t)%mod;
                }
            }
        }

        int res = 0;
        for(int i=0;i<m;i++){
            res = (res + dp[i])%mod;
        }
        return (res<<1)%mod;
    }
}