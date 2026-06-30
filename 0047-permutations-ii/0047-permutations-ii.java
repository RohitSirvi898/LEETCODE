class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean vis[] = new boolean[nums.length];
        helper(nums,new ArrayList<>(),vis);
        return ans;
    }

    public void helper(int[] nums, List<Integer> temp,boolean[] vis){
        if(temp.size()==nums.length){
            if(!ans.contains(temp)) ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                temp.add(nums[i]);
                helper(nums,temp,vis);
                temp.removeLast();
                vis[i] = false;
            }
        }
    }
}