class Solution {
    public long count(int[] nums, long target){
        int i=0;
        int j=nums.length-1;
        long ans = 0;
        while(i<j){
            if(nums[i]+nums[j]<=target){
                ans+=(j-i);
                i++;
            }
            else j--;
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums,upper)-count(nums,lower-1);
    }
}