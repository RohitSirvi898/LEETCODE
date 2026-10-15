
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] ans = new int[n][m];

        for (int i=0; i<n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2],b[2]));
        ans[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int weight = curr[2];

            if (weight>ans[i][j]) {
                continue;
            }
            if (i==n-1 && j==m-1) {
                return weight;
            }

            for (int[] next:dir) {
                int r = i+next[0];
                int c = j+next[1];

                if (r>=0 && r<n && c>=0 && c<m) {
                    int diff = Math.abs(heights[i][j] - heights[r][c]);
                    int min = Math.max(diff, weight);
                    if (min < ans[r][c]) {
                        ans[r][c] = min;
                        pq.offer(new int[]{r,c,min});
                    }
                }
            }
        }
        return 0;
    }
}
