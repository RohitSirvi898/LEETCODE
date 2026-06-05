class Solution {
    public int minDays(int[] bloomDay, int mo, int k) {
        int n = bloomDay.length;
        int l=1;
        int h = 0;
        for(int i:bloomDay){
            h = Math.max(i,h);
        }
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            int count = 0;
            int bouq = 0;
            for(int i=0;i<n;i++){
                if(bloomDay[i]<=m) count++;
                else {
                    bouq+=count/k;
                    count=0;
                }
            }
            bouq+=count/k;
            if(bouq>=mo){
                h=m-1;
                ans = m;
            }
            else l=m+1;
        }
        return ans;
    }
}