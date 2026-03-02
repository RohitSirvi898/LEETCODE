class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int maxRight[] = new int[n];
        for(int i=0;i<n;i++){
            int j=n-1;
            while(j>=0 && grid[i][j]==0){
                j--;
            }
            maxRight[i]=n-j-1;
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            int needed = n-i-1;
            int j=i;
            while(j<n && maxRight[j]<needed) j++;

            if(j==n) return -1;

            while(j>i){
                int temp = maxRight[j];
                maxRight[j] = maxRight[j-1];
                maxRight[j-1] = temp;
                swaps++;
                j--;
            }
        }
        return swaps;
    }
}