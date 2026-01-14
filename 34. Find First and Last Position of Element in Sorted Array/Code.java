class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{startIndex(nums,target),endIndex(nums,target)};
    }
    public int startIndex(int nums[],int target){
        int ans=-1;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target){
                ans=m;
                h=m-1;
            }
            else if(nums[m]>target) h=m-1;
            else l=m+1;
        }
        return ans;
    }
    public int endIndex(int nums[],int target){
        int ans=-1;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target){
                ans=m;
                l=m+1;
            }
            else if(nums[m]>target) h=m-1;
            else l=m+1;
        }
        return ans;
    }
}