class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }

    public int helper(int[] nums, int k){
        int sum = 0;
        int count = 0;
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0) sum++;
            while(sum>k){
                if(nums[j]%2!=0) sum--;
                j++;
            }
            count+=(i-j+1);
        }
        return count;
    }
}