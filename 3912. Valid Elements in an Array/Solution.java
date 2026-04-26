class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int suffix[] = new int[n];
        int leftmax = nums[0];
        ans.add(nums[0]);
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1],nums[i]);
        }
        for(int i = 1; i < n-1; i++){
            if(leftmax<nums[i] || suffix[i+1]<nums[i]) ans.add(nums[i]);
            leftmax = Math.max(leftmax,nums[i]);
        }
        if(n>1) ans.add(nums[n-1]);
        return ans;
    }
}