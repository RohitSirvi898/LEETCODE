class Solution {

    public boolean findpath(boolean[] vis,List<List<Integer>> graph,int s,int d){
        if(s==d) return true;
        vis[s]=true;
        for(int i:graph.get(s)){
            if(!vis[i]){
                if(findpath(vis,graph,i,d)) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        return findpath(vis,graph,source,destination);
    }
}