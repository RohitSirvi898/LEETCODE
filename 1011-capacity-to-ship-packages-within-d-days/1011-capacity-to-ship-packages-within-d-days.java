class Solution {

    public static boolean isPossible(int[] weights, int h, int m){
        int count = 0;
        int load = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>m) return false;
            if(load+weights[i]>m) {
                load = 0;
                count++;
            }
            load+=weights[i];
        }
        if(load<=m) count++;
        return count<=h;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = weights[0];
        int high = 0;
        for(int i=0;i<n;i++){
            low = Math.min(low,weights[i]);
            high += weights[i];
        }

        while(low<high){
            int m = low+(high-low)/2;
            if(isPossible(weights,days,m)) high=m;
            else low=m+1;
        }

        return high;
    }
}