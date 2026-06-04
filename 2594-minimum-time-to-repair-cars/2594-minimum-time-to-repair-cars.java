class Solution {
    public static boolean isPossible(int[] ranks, int cars, long m){
        long count = 0;
        for(int i=0;i<ranks.length;i++){
            count += Math.sqrt((double)m/ranks[i]);
        }
        return count>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long h = Long.MAX_VALUE;
        while(l<h){
            long m = l+(h-l)/2;
            if(isPossible(ranks,cars,m)) h=m;
            else l=m+1;
        }
        return h;
    }
}