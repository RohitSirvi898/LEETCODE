class Solution {
    public void helper(List<List<Integer>> list, List<Integer> helper, int idx, int sum, int k, int n){
        if(helper.size()>k) return;
        if(sum==n && helper.size()==k){
            list.add(new ArrayList<>(helper));
            return;
        }
        for(int i=idx;i<10;i++){
            helper.add(i);
            helper(list,helper,i+1,sum+i,k,n);
            helper.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), 1, 0, k, n);
        return list;
    }
}