class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        int n = colors.length();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[n];
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            char cu = colors.charAt(u);
            char cv = colors.charAt(v);

            if(isNext(cu,cv)) {
                indeg[v]++;
                adj.get(u).add(v);
            }
            else if(isNext(cv,cu)) {
                indeg[u]++;
                adj.get(v).add(u);
            }
            else return -1;
        }

        int root = -1;
        for(int i=0;i<n;i++){
            if(indeg[i]==0) {
                if(root!=-1) return -1;
                root = i;
            }
            else if(indeg[i]!=1) return -1;
        }

        if(root==-1) return -1;
        if(adj.get(root).size()>2) return -1;

        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();

        que.add(root);
        vis[root] = true;

        char levelColor = colors.charAt(root);
        int visitCount = 0;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int curr = que.poll();
                visitCount++;
                
                if(colors.charAt(curr)!=levelColor) return -1;
    
                for(int next : adj.get(curr)){
                    if(!vis[next]){
                        vis[next] = true;
                        que.add(next);
                    }
                }
            }
            levelColor = getNextColor(levelColor);
        }

        return visitCount==n?root:-1;
        
    }

    public boolean isNext(char parent, char child){
        return (parent == 'R' && child == 'B') ||
               (parent == 'B' && child == 'W') ||
               (parent == 'W' && child == 'R');
    }

    public char getNextColor(char c){
        if(c=='R') return 'B';
        else if(c=='B') return 'W';
        return 'R';
    }
}