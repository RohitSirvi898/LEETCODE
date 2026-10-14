class Solution {
    int ans = 1;
    public int longestPath(int[] parent, String s) {
        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();

        for(int i=0;i<parent.length;i++){
            tree.put(i,new ArrayList<>());
        }
        for(int i=0;i<parent.length;i++){
            if(i==0) continue;
            tree.get(parent[i]).add(i);
        }
        dfs(tree,s,0);
        return ans;
    }

    public int dfs(HashMap<Integer,ArrayList<Integer>> tree, String s, int curr){
        if(tree.get(curr).size()==0) return 1;
        int maxlen1 = 0;
        int maxlen2 = 0;
        for(int i:tree.get(curr)){
            int len = dfs(tree,s,i);
            if(s.charAt(curr)!=s.charAt(i)) {
                if(len>=maxlen1){
                    maxlen2 = maxlen1;
                    maxlen1 = len;
                }
                else if(len>maxlen2){
                    maxlen2 = len;
                }
            }
        }
        ans = Math.max(maxlen1+maxlen2+1,ans);
        return maxlen1+1;
    }
}