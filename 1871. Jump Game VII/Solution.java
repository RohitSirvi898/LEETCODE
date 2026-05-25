class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        if(s.charAt(n-1)=='1') return false;
        dp[0]=true;
        int l = 0;
        int r = 0;

        for(int i=0;i<n;i++){
            if(!dp[i]) continue;

            l = Math.max(i+minJump,r+1);
            r = Math.min(n-1,i+maxJump);
            for(int j=l; j<=r; j++){
                if(s.charAt(j)=='0' && !dp[j]) {
                    dp[j] = true;
                }
            }
            if(dp[n-1]) return true;
        }

        return dp[n-1];
    }
}