class Solution {
    public void dfs(int[][] isConnected,boolean[] vis,int idx){
        vis[idx] = true;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i] && isConnected[idx][i]==1){
                dfs(isConnected,vis,i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(isConnected, vis, i);
            }
        }
        return count;
    }
}