class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int smallest = Integer.MAX_VALUE;
        int secondsmallest = Integer.MAX_VALUE;
        for (int i=1;i<n;i++) {
            if (nums[i] <= smallest) {
                secondsmallest = smallest;
                smallest = nums[i];
            }
            else if (nums[i] <= secondsmallest) {
                secondsmallest = nums[i];
            }
        }
        return smallest + secondsmallest + first;
    }
}