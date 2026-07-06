class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int[] dp = new int[2];

        for (char c : t.toCharArray()) {
            if (dp[1] < s.length() && c == s.charAt(dp[1])) {
                ++dp[1];
            }

            dp[1] = Math.max(dp[1], dp[0] + 1);

            if (dp[0] < s.length() && c == s.charAt(dp[0])) {
                ++dp[0];
            }

            if (dp[1] == s.length()) {
                return true;
            }
        }

        return false;
    }
}