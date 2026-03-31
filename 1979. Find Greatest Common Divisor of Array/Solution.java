class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(min>nums[i]) min=nums[i];
            if(max<nums[i]) max=nums[i];
        }
        return GCD(max,min);
    }

    public int GCD(int a, int b){
        while(b!=0){
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}