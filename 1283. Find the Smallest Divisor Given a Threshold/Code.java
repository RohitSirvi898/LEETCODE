class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int h=Integer.MIN_VALUE;
        
        for(int num:nums){
            h=Math.max(h,num);
        }

        while(l<h){
            int m=l+(h-l)/2;
            int count=0;
            for(int num:nums){
                count+=(num+m-1)/m;
            }
            if(count<=threshold) h=m;
            else l=m+1;
        }
        return h;
    }
}