class Solution {
    public void helper(List<List<Integer>> list, List<Integer> helper, int[] nums, int idx){
        list.add(new ArrayList<>(helper));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            helper.add(nums[i]);
            helper(list,helper,nums,i+1);
            helper.removeLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),nums,0);
        return list;
    }
}