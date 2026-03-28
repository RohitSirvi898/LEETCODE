class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int as = 10000;
        int pos1 = -1;
        int pos2 = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                pos1 = i;
                if(pos2 != -1){
                    as = Math.min(as,pos1 - pos2);
                }
            } else if(nums[i] == 2){
                pos2 = i;
                if(pos1 != -1){
                    as = Math.min(as, pos2 - pos1);
                }
            }
        }
        if(as == 10000){
            return -1;
        }
        return as;
    }
}