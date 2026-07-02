class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        int[][] maxHealth = new int[n][m];
        
        maxHealth[0][0] = health-grid.get(0).get(0);
        q.add(new int[]{0,0,maxHealth[0][0]});

        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            int h = arr[2];

            if(r==n-1 && c==m-1) return true;

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                int newhealth = h-grid.get(nr).get(nc);
                if(newhealth > 0 && newhealth > maxHealth[nr][nc]){
                    maxHealth[nr][nc] = newhealth;
                    q.add(new int[]{nr,nc,newhealth});
                }
            }
        }
        return false;
    }
}