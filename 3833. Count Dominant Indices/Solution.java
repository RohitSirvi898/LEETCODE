class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int count=0;
        int sum=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>(sum)/(n-i-1)){
                count++;
            }
            sum+=nums[i];
        }
        return count;
    }
}