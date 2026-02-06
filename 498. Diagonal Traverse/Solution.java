class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int r=0;
        int c=0;
        int[] ans=new int[n*m];
        for(int i=0;i<n*m;i++){
            ans[i]=mat[r][c];
            if((r+c)%2==0){
                if(c==m-1) r++;
                else if(r==0) c++;
                else{
                    r--;
                    c++;
                }
            }
            else{
                if(r==n-1) c++;
                else if(c==0) r++;
                else{
                    c--;
                    r++;
                }
            }
        }
        return ans;
    }
}