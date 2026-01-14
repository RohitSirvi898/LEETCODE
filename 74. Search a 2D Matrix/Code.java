class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n= matrix[0].length;
        int l=0;
        int h=m*n-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            int rowmid=mid/n;
            int colmid=mid%n;
            if(matrix[rowmid][colmid]==target) return true;
            else if(matrix[rowmid][colmid]>target) h=mid-1;
            else l=mid+1;
        }
        return false;
    }
}