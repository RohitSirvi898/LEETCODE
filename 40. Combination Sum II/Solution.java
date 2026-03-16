class Solution {
    public void helper(List<List<Integer>> list, List<Integer> helper, int[] candidates, int target, int sum, int idx){
        if(sum==target){
            list.add(new ArrayList<>(helper));
            return;
        }
        else if(sum>target) return;

        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            helper.add(candidates[i]);
            helper(list,helper,candidates,target,sum+candidates[i],i+1);
            helper.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> helper = new ArrayList<>();
        helper(list,helper,candidates,target,0,0);
        return list;
    }
}