class Solution {

    public static boolean isPossible(int[] piles, int h, int m){
        int count = 0;
        for(int i=0;i<piles.length;i++){
            count+=(piles[i]+m-1)/m;
        }
        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = piles[0];
        for(int i=0;i<n;i++){
            high = Math.max(high,piles[i]);
        }

        while(low<high){
            int m = low+(high-low)/2;
            if(isPossible(piles,h,m)) high=m;
            else low=m+1;
        }

        return high;
    }
}