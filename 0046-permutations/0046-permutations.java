class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        helper(nums,new ArrayList<>(),vis);
        return ans;
    }

    public void helper(int[] nums, List<Integer> temp,boolean[] vis){

        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                temp.add(nums[i]);
                helper(nums,temp,vis);
                vis[i]=false;
                temp.removeLast();
            }
        }
    }
}