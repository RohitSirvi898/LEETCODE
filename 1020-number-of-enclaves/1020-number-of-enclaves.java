class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int totalLand = 0;

        boolean[][] vis = new boolean[m][n];

        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i == m - 1 || j == n - 1) && grid[i][j]==1) {
                    vis[i][j]=true;
                    que.offer(new int[]{i,j});
                } 
                if(grid[i][j]==1) totalLand++;
            }
        }

        int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];
            totalLand--;
            for(int[] next : dir){
                int i = r+next[0];
                int j = c+next[1];

                if(i>=0 && j>=0 && i<m && j<n && !vis[i][j] && grid[i][j]==1){
                    vis[i][j] = true;
                    que.offer(new int[]{i,j});
                }
            }
        }

        return totalLand;
    }
}