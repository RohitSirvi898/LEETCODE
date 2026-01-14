class Solution {
    public boolean isPossible(int[] piles, int m, int h){
        long count=0;
        for(int i=0;i<piles.length;i++){
            count+=(piles[i]+m-1)/m;   
        }
        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(piles[i],high);
        }
        while(low<high){
            int m=low+(high-low)/2;
            if(isPossible(piles,m,h)){
                high=m;
            }
            else{
                low=m+1;
            }
        }
        return high;
    }
}