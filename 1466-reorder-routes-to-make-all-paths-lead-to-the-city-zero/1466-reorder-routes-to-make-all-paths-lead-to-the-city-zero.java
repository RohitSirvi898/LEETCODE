class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            graph.get(u).add(new int[]{v,1});
            graph.get(v).add(new int[]{u,0});
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[n];
        que.offer(0);
        vis[0] = true;
        int count = 0;
        while(!que.isEmpty()){
            int curr = que.poll();
            for(int[] next : graph.get(curr)){
                if(!vis[next[0]]){
                    if(next[1]==1) count++;
                    vis[next[0]]=true;
                    que.offer(next[0]);
                }
            }
        }

        return count;
    }
}