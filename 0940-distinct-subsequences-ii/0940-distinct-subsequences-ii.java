class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[26];
        int total = 0;

        for(int i=0;i<n;i++){
            int c = s.charAt(i)-'a';
            int add = (total - dp[c] + mod)%mod;
            dp[c] = total+1;
            total = (dp[c] + add)%mod;
        }
        return total;
    }
}