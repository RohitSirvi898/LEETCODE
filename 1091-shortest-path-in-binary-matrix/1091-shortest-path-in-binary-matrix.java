class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        boolean[][] vis = new boolean[n][n];

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});

        int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int x=0;x<size;x++){
                int[] curr = que.poll();
                int r=curr[0];
                int c=curr[1];

                if(r==n-1 && c==n-1) return count;
                for(int[] dir : dirs){
                    int i=r+dir[0];
                    int j=c+dir[1];
                    if(i>=0 && i<n && j>=0 && j<n && !vis[i][j] && grid[i][j]==0){
                        que.offer(new int[]{i,j});
                        vis[i][j]=true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}