class Solution {
    public void helper(List<List<Integer>> list,List<Integer> helper,int[] candidates,int target,int sum,int idx){
        if(sum==target){
            list.add(new ArrayList<>(helper));
            return;
        }
        else if(sum>target) return;

        for(int i=idx;i<candidates.length;i++){
            helper.add(candidates[i]);
            helper(list,helper,candidates,target,sum+candidates[i],i);
            helper.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),candidates,target,0,0);
        return list;
    }
}