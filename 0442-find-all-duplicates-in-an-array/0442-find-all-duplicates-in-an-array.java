class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i:nums){
            int idx = Math.abs(i)-1;
            if(nums[idx]<0){
                ans.add(Math.abs(idx+1));
            }
            nums[idx] = -nums[idx];
        }
        return ans;
    }
}