class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int counts[][] = new int[n][2];
        for(int i=0;i<n;i++){
            counts[i][0]=i;
            for(int j=0;j<m;j++){
                counts[i][1]+=mat[i][j];
            }
        }
        Arrays.sort(counts,(a,b)->{
            if(a[1]==b[1]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=counts[i][0];
        }

        return ans;

    }
}