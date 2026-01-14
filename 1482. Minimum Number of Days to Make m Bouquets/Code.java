class Solution {

    public boolean isPossible(int[] bloomDay,int m,int k,int mid){
        long count=0;
        long flower=0;
        for(int bloom:bloomDay){
            if(bloom<=mid) flower++;
            else flower=0;
            if(flower==k) {
                count++;
                flower=0;
            }
        }
        return count>=m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length) return -1;
        int low=1;
        int high=0;

        for(int bloom:bloomDay) high=Math.max(bloom,high);

        while(low<high){
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,m,k,mid)) high=mid;
            else low=mid+1;
        }
        return high;
    }
}