class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int gt = 0;
        int lt = 0;
        int start = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) start = i;
            if(nums[(i+1)%n]>nums[i]) {
                gt++;
            }
            else lt++;
        }
        if (Math.min(gt, lt) > 1) return -1;

        if (lt <= 1) { 
            return Math.min(start, n - start + 2);
        } 
        else { 
            return Math.min(n - start, start + 2);
        }
    }
}