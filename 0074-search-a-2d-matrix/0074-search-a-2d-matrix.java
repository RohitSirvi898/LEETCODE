class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;//row
        int m = matrix[0].length;//column
        int l = 0;
        int h = n*m - 1;
        while(l<=h){
            int mid = l+(h-l)/2;
            int m1 = mid/m;
            int m2 = mid%m;
            if(matrix[m1][m2] == target) return true;
            else if(matrix[m1][m2] < target) l=mid+1;
            else h = mid-1;
        }
        return false;
    }
}