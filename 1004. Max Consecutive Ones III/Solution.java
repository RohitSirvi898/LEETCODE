class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int count0 = 0;
        int left = 0;
        int ans = 0;
        for(int right=0;right<n;right++){
            
            if(nums[right]==0) count0++;
            if(count0>k){
                if(nums[left]==0) count0--;
                left++;
            }
            ans = Math.max(right-left+1,ans);
        } 
        return ans;
    }
}