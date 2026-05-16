class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0,end = n-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[end]>nums[mid]) end = mid;
            else if(nums[end]<nums[mid]) start = mid+1;
            else end--;
        }
        return nums[start];
    }
}