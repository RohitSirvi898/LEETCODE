class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        for(int i = 0;i<n;i++){
            int steps = nums[i];
            result[i] = nums[(i+(steps)%n+n)%n];
        }
        return result;
    }
}