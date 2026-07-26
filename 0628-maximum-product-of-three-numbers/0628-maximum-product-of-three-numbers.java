class Solution {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        int minfirst = Integer.MAX_VALUE;
        int minsecond = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=first){
                third = second;
                second = first;
                first = nums[i];
            }
            else if(nums[i]>=second){
                third = second;
                second = nums[i];
            }
            else if(nums[i]>=third){
                third = nums[i];
            }

            if(nums[i]<=minfirst){
                minsecond = minfirst;
                minfirst = nums[i];
            }
            else if(nums[i]<=minsecond){
                minsecond = nums[i];
            }
        }

        return Math.max(first*second*third,minfirst*minsecond*first);
    }
}