class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 2;
        for(int i = 2;i<nums.length;i++){
            if(nums[i]!=nums[curr-2]) nums[curr++] = nums[i];
        }
        return curr;
    }
}