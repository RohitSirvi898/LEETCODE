class Solution {
    int minXor = Integer.MAX_VALUE;
    boolean[][][] visited;

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m][1024];
        dfs(grid, 0, 0, 0);
        return minXor;
    }

    private void dfs(int[][] grid, int i, int j, int currentXor) {
        currentXor ^= grid[i][j];
        
        if (visited[i][j][currentXor]) return;
        visited[i][j][currentXor] = true;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            minXor = Math.min(minXor, currentXor);
            return;
        }

        if (j + 1 < grid[0].length) dfs(grid, i, j + 1, currentXor);
        if (i + 1 < grid.length) dfs(grid, i + 1, j, currentXor);
    }
}