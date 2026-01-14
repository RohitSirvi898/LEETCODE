class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0;
        long sum=0;
        int min = Integer.MAX_VALUE;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int[] row:matrix){
            for(int value:row){
                if(value<=0){
                    value=-value;
                    count++;
                }
                sum+=value;
                if(value<min) min=value;
            }
        }
        return (count%2!=0)? sum-(min*2):sum;
    }
}