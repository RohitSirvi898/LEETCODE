class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n=nums.length;
        long[] gains = new long[n];
        long totalSum = 0;

        for(int i=0;i<n;i++){
            int original = nums[i];
            totalSum+=original;
            long maxVal = getMaxValue(original);
            gains[i] = (long)maxVal-original;
        }

        Arrays.sort(gains);

        for(int i=n-1;i>=0 && k>0;i--){
            totalSum+=gains[i];
            k--;
        }
        return totalSum;
    }

    public long getMaxValue(int original){
        char arr[] = String.valueOf(original).toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}