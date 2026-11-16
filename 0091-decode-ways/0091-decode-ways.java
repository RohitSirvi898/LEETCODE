class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0') continue;
            int one = dp[i+1];
            int two = 0;
            if(i+1<n){
                int num = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
                if(num>=10 && num<=26) two = dp[i+2]; 
            }
            dp[i] = one+two;
        }
        return dp[0];
    }
}