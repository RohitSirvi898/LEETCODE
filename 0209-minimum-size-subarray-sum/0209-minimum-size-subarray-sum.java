class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 1;
        int high = nums.length;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isValid(mid,target,nums)){
                ans=mid;
                high=mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    public boolean isValid(int mid, int target, int[] nums){
        int j=0;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>=target) return true;
            if(i-j+1==mid) {
                sum-=nums[j];
                j++;
            }
        }
        return false;

    }
}