class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int prev = 0;
        int count = 1;
        int j = 0;
        for(int i=0;i<n;i++){
            if(prev != nums[i]){
                prev = nums[i];
                count = 1;
            }
            nums[j] = nums[i];
            if(count<=k){
                j++;
            }
            count++;
        }
        return Arrays.copyOf(nums,j);
    }
}