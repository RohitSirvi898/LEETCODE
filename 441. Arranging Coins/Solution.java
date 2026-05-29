class Solution {
    public int arrangeCoins(int n) {
        int l =0;
        int h = n;
        while(l<=h){
            int m = l+(h-l)/2;
            long num = (long)m*(m+1)/2;
            if(num==n) return m;
            else if(num>n) h = m-1;
            else l = m+1;
        }
        return h;
    }
}