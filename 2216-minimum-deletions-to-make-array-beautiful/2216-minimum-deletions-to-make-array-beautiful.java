class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int idx = 0;
        int count = 0;
        for(int i=0;i<n-1;i++){
            if(idx%2==0 && nums[i]==nums[i+1]){
                count++;
                continue;
            }
            idx++;
        }
        if(idx%2==0) return count+1;
        return count;
    }
}