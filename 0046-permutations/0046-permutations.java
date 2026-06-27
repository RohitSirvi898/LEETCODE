class Solution {
    HashSet<Integer> set = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, List<Integer> temp){

        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                temp.add(nums[i]);
                helper(nums,temp);
                set.remove(nums[i]);
                temp.removeLast();
            }
        }
    }
}