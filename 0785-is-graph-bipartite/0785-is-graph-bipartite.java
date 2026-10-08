class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            color[i]=1;
            if(!dfs(graph,i,color)) return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph, int v, int[] color){
        for(int i:graph[v]){
            if (color[i] == 0) {
                color[i] = -color[v];
                if(!dfs(graph,i,color)) return false;
            }
            else if (color[i] == color[v]) return false;
        }
        return true;
    }
    // public boolean isBipartite(int[][] graph) {
    //     int n = graph.length;
    //     int[] color = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         if (color[i] != 0) continue;
    //         Queue<Integer> que = new LinkedList<>();
    //         que.offer(i);
    //         color[i] = 1;

    //         while (!que.isEmpty()) {
    //             int u = que.poll();

    //             for (int v : graph[u]) {
    //                 if (color[v] == 0) {
    //                     color[v] = -color[u];
    //                     que.offer(v);
    //                 }
    //                 else if (color[v] == color[u]) return false;
    //             }
    //         }
    //     }

    //     return true;
    // }
}