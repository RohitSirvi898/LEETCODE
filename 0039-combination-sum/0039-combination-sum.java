class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        helper(candidates,target,temp,0,0);
        return ans;
    }

    public void helper(int[] candidates, int target, List<Integer> temp, int sum, int i){
        if(i>=candidates.length) return;
        if(sum==target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum+candidates[i]<=target){
            temp.add(candidates[i]);
            helper(candidates,target,temp,sum+candidates[i],i);
            temp.removeLast();
        }
        helper(candidates,target,temp,sum,i+1);
    }
}