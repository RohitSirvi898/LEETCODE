import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            int colidx=-1;
            for(int j=0;j<m;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                    colidx=j;
                }
            }
            boolean isLucky = true;
            for(int j=0;j<n;j++){
                if(matrix[j][colidx]>min) isLucky=false;
            }
            if(isLucky) ans.add(min);
        }
        
        return ans;
    }
}