class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int inc = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inc += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }

        return inc;
    }
}