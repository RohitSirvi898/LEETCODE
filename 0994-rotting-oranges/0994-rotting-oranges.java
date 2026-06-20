class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<m*n;i++){
            int row = i/n;
            int col = i%n;
            if(grid[row][col]==1) fresh++;
            if(grid[row][col] == 2) que.add(i);
        }
        int count = -1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int idx = que.poll();
                int row = idx/n;
                int col = idx%n;
                // System.out.println(row+" "+col);
                if(row>0 && grid[row-1][col]==1) {
                    que.add(idx-n);
                    grid[row-1][col]=2;
                    fresh--;
                }
                if(col>0 && grid[row][col-1]==1) {
                    que.add(idx-1);
                    grid[row][col-1]=2;
                    fresh--;
                }
                if(row<m-1 && grid[row+1][col]==1) {
                    que.add(idx+n);
                    grid[row+1][col]=2;
                    fresh--;
                }
                if(col<n-1 && grid[row][col+1]==1) {
                    que.add(idx+1);
                    grid[row][col+1]=2;
                    fresh--;
                }
            }
            count++;
        }
        if(fresh!=0) return -1;
        if(count==-1) return 0;
        return count;
    }
}