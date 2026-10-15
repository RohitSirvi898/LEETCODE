class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time:times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v,w});
        }

        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        ans[k]=0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int distance = curr[1];
            for(int[] next : graph.get(curr[0])){
                if(ans[next[0]]>distance+next[1]){
                    ans[next[0]] = distance+next[1];
                    pq.offer(new int[]{next[0],ans[next[0]]});
                }
            }
        }

        int mintime = 0;

        for(int i=1;i<n+1;i++){
            mintime = Math.max(ans[i],mintime);
        }

        return mintime==Integer.MAX_VALUE?-1:mintime;
    }
}