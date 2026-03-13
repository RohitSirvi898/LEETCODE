class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l=0,h=10000000000000000L;
        while(l<h){
            long m = (h+l)>>1;
            long tot = 0;
            for(int i=0;i<workerTimes.length;i++){
                tot+=(long)(Math.sqrt((double)m/workerTimes[i]*2+0.25)-0.5);
            }
            if(tot>=mountainHeight) h = m;
            else l = m + 1;
        }
        return l;
    }
}