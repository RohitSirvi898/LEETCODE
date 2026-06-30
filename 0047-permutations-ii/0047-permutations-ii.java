class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(nums,0);
        return ans;
    }

    public void helper(int[] nums, int idx){
        if(idx==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num:nums) temp.add(num);
            ans.add(temp);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        
        for(int i=idx;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums,i,idx);
            helper(nums,idx+1);
            swap(nums,i,idx);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}