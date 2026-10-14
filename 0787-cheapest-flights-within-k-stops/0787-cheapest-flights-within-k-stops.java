class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans = Integer.MAX_VALUE;
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph.get(u).add(new int[]{v,w});
        }
        
        int costs[] = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{src,0});
        costs[src] = 0;
        int steps = 0;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int[] curr = que.poll();
                int distance = curr[1];
                for(int[] next : graph.get(curr[0])){
                    int weight = next[1];
                    if(costs[next[0]]>distance+weight){
                        costs[next[0]] = distance+weight;
                        que.offer(new int[]{next[0],distance+weight});
                    }
                }
            }
            if(steps<=k){
                ans = Math.min(ans,costs[dst]);
            }
            steps++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;

    }
}