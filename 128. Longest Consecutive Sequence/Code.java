class Solution {
    // set insertion time is O(nlogn)
    // sorting array is faster than inserting in set
    // Iteration in set is faster than iteration in array
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int max=1;
        int count=1;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int curr=nums[i];
            if(nums[i]==nums[i+1]) continue;
            if(nums[i+1]==nums[i]+1) count++;
            else{
                max=Math.max(count,max);
                count=1;
            }
        }
        return Math.max(count,max);
    }
}