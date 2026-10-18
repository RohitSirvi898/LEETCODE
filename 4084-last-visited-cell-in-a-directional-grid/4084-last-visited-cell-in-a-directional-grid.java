class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        int r = 0;
        int c = 0;
        vis[r][c] = true;

        while(true) {
            char dir = grid[r][c];
            int nextR = r;
            int nextC = c;

            if(dir=='L') nextC--;
            else if(dir=='R') nextC++;
            else if(dir=='U') nextR--;
            else if(dir=='D') nextR++;

            if(nextR<0 || nextR>=m || nextC<0 || nextC>=n || vis[nextR][nextC]) break;

            r = nextR;
            c = nextC;
            vis[r][c] = true;
        }

        return new int[]{r,c};
    }
}