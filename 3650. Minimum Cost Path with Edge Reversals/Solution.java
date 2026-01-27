class Solution {
    public int minCost(int n, int[][] edges) {
        
        List<List<int[]>> G = new ArrayList<>(n);
        for(int i=0;i<n;i++) G.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            G.get(u).add(new int[]{v,w});
            G.get(v).add(new int[]{u,2*w});
        }

        int dist[]=new int[n];
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int u = pq.poll()[1];
            if(vis[u]) continue;
            vis[u]=true;
            
            for(int[] e:G.get(u)){
                int v=e[0];
                int w=e[1];
                if(dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                    pq.offer(new int[]{dist[u]+w,v});
                }
            }
        }
        
        return dist[n-1] == Integer.MAX_VALUE?-1:dist[n-1];
    }
}