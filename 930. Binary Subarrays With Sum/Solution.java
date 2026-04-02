class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = helper(nums,goal);
        int right = helper(nums,goal-1);
        System.out.println(left+" "+right);
        return left-right;
    }
    public int helper(int[] nums, int goal){
        int n = nums.length;
        int count = 0;
        int sum = 0;
        int j = 0;
        for(int i = 0; i<n; i++){
            sum+=nums[i];
            while(sum>goal && j<=i){
                sum-=nums[j++];
            }
            count+=(i-j+1);
        }
        return count;
    }
}