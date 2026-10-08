class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++)
        {
            if(union(edges[i][0],edges[i][1],parent))
            {
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{0,0};
    }

    boolean union(int u,int v,int[] parent)
    {
        int p1=find(u,parent);
        int p2=find(v,parent);

        if(p1==p2)
        {
            return true;
        }
        parent[p2]=p1;
        return false;
    }

    int find(int u,int[] parent)
    {
        if(parent[u]==u)
        {
            return u;
        }
        return find(parent[u],parent);
    }
}