class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> ans=new ArrayList<>();
        int[] prev=intervals[0];
        int n=intervals.length;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=prev[1]){
                prev[1]=Math.max(prev[1],intervals[i][1]);
            }
            else{
                ans.add(prev);
                prev=intervals[i];
            }
        }
        ans.add(prev);
        return ans.toArray(new int[ans.size()][]);

    }
}