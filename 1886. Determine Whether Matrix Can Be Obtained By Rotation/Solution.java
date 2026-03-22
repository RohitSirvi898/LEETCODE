class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for(int rot=0;rot<4;rot++){
            for(int i=0;i<n/2;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]+=mat[n-i-1][j];
                    mat[n-i-1][j]=mat[i][j]-mat[n-i-1][j];
                    mat[i][j]=mat[i][j]-mat[n-i-1][j];
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    mat[i][j]+=mat[j][i];
                    mat[j][i]=mat[i][j]-mat[j][i];
                    mat[i][j]=mat[i][j]-mat[j][i];
                }
            }

            boolean flag = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]!=target[i][j]) flag=false;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}