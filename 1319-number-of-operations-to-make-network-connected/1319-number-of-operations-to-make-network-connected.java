class Solution {
    public void DFS(List<List<Integer>> graph,boolean[] vis,int s){
        vis[s] = true;
        for(int i:graph.get(s)){
            if(!vis[i]){
                DFS(graph,vis,i);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        List<List<Integer>> graph = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                DFS(graph,vis,i);
            }
        }
        return count-1;
    }
}