class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long max_sum = 100_000_000_000_000L;
        long[] rightprod = new long[n];
        rightprod[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            long prevprod = rightprod[i+1];
            long currentval = nums[i+1];
            if(prevprod > max_sum/currentval){
                rightprod[i] = max_sum+1;
            }
            else{
                long currentprod = prevprod * currentval;
                if(currentprod > max_sum){
                    rightprod[i] = max_sum + 1;
                }
                else{
                    rightprod[i] = currentprod;
                }
            }
        }
        long leftsum = 0;
        for(int i=0;i<n;i++){
            if(leftsum == rightprod[i]){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}