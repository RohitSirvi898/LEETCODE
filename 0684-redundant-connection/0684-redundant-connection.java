class Solution {

    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        int ans[] = new int[2];
        for(int[] i : edges){
            int a = i[0];
            int b = i[1];
            boolean vis[] = new boolean[n+1];
            solve(edges,a,-1,vis,map,ans);
            if(vis[b]) return i;
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return ans;
    }

    public boolean solve(int[][] edges, int v, int u, boolean[] vis,HashMap<Integer,ArrayList<Integer>> map, int[] ans){
        vis[v] = true;
        for(int i:map.get(v)){
            if(i==u) continue;
            if(vis[i] || i==u){
                ans[0] = u;
                ans[1] = v;
                return true;
            }
            if(solve(edges,i,v,vis,map,ans)) return true;
        }
        return false;
    }
}