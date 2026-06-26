class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        ans.add(temp);
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            helper(ans,temp,nums,i+1);
            temp.removeLast();
        }
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int i){
        if(i>=nums.length) return;
        temp.add(nums[i]);
        ans.add(new ArrayList<>(temp));
        helper(ans,temp,nums,i+1);
        temp.removeLast();
        helper(ans,temp,nums,i+1);
    }
}