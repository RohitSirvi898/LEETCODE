class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int l=1;
        int h=0;
        for(int i:candies){
            h = Math.max(i,h);
        }
        int ans = 0;
        while(l<=h){
            int m = l+(h-l)/2;
            long count = 0;
            for(int i=0;i<n;i++){
                count+=candies[i]/m;
            }
            if(count>=k) {
                l=m+1;
                ans = m;
            }
            else h=m-1;
        }
        return ans;
    }
}