class Solution {
    public int countCommas(int n) {
        int ans = n-1000;
        return ans>=0?ans+1:0;
    }
}