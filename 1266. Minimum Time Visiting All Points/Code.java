class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        int sum=0;
        for(int i=1;i<n;i++){
            int max=Math.max(Math.abs(points[i][0]-points[i-1][0]),Math.abs(points[i][1]-points[i-1][1]));
            sum+=max;
        }
        return sum;
    }
}