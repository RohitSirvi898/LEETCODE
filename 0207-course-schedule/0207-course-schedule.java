class Solution {
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     int[] depency = new int[numCourses];
    //     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //     for(int i=0;i<numCourses;i++){
    //         graph.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<prerequisites.length;i++){
    //         depency[prerequisites[i][0]]++;
    //         graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    //     }
    //     Queue<Integer> que = new LinkedList<>();
    //     for(int i=0;i<numCourses;i++){
    //         if(depency[i]==0) que.offer(i);
    //     }
    //     if(que.isEmpty()) return false;
    //     int count = 0;
    //     while(!que.isEmpty()){
    //         int curr = que.poll();
    //         for(int i:graph.get(curr)){
    //             depency[i]--;
    //             if(depency[i]==0) que.offer(i);
    //         }
    //         count++;
    //     }
    //     return count==numCourses;
    // }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (!vis[i] && dfs(i, adj, vis, path)) return false;

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[node] = path[node] = true;

        for (int next : adj.get(node))
            if (!vis[next] && dfs(next, adj, vis, path)) return true;
            else if (path[next]) return true;
            
        path[node] = false;
        return false;
    }
}