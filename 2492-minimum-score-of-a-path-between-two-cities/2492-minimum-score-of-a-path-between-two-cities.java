class Solution {
    int mini = Integer.MAX_VALUE;
    public void helper(List<List<int[]>> graph, int i, boolean[] vis){
        vis[i] = true;
        for(int[] node:graph.get(i)){
            mini = Math.min(mini,node[1]);
            if(!vis[node[0]]){
                helper(graph,node[0],vis);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n+1];
        for(int[] road:roads){
            graph.get(road[0]).add(new int[]{road[1],road[2]});
            graph.get(road[1]).add(new int[]{road[0],road[2]});
        }
        helper(graph,1,vis);
        return mini;
    }
}