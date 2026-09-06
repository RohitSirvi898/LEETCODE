class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n/2;
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<half;i++){
            sum1+=nums[i];
            sum2+=nums[i+half];
        }

        int good = 0;

        for(int i=0;i<n;i++){
            if(sum1>sum2) good++;

            long leftfirst = nums[i];
            long rightfirst = nums[(i+half)%n];

            sum1 = sum1-leftfirst+rightfirst;
            sum2 = sum2-rightfirst+leftfirst;
        }

        return good;
    }
}