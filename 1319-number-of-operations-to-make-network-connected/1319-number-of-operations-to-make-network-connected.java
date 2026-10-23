class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        int components = n;
        for(int[] c:connections){
            int p1 = findParent(parent,c[0]);
            int p2 = findParent(parent,c[1]);

            if(p1!=p2) {
                parent[p1]=p2;
                components--;
            }
        } 

        return components-1;
    }

    public int findParent(int[] parent,int p1){
        if(p1!=parent[p1]) parent[p1] = findParent(parent,parent[p1]);
        return parent[p1];
    }
}