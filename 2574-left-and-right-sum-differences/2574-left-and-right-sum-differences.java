class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int leftsum = 0;
        int rightsum = 0;
        for(int i:nums){
            leftsum+=i;
        }
        for(int i=0;i<n;i++){
            leftsum-=nums[i];
            ans[i] = Math.abs(leftsum-rightsum);
            rightsum+=nums[i];
        }
        return ans;
    }
}