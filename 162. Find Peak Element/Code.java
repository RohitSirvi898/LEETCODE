class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if((m==0 && nums[m]>nums[m+1]) || (m==nums.length-1 && nums[m]>nums[m-1])) return m;
            if(m>0 && m<nums.length-1 && nums[m]>nums[m-1] && nums[m]>nums[m+1]) return m;
            else if(nums[m]<nums[m+1]) l=m+1;
            else h=m-1;
        }
        return -1;
    }
}