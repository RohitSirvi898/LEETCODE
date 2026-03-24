class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long sufprod = 1;
        long preprod = 1;
        int ans[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = 1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = (int)(ans[i][j]*sufprod)%12345;
                sufprod = (sufprod*grid[i][j])%12345;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                ans[i][j] = (int)(ans[i][j]*preprod)%12345;
                preprod = (preprod*grid[i][j])%12345;
            }
        }

        return ans;
    }
}