class Solution {
    public boolean canAliceWin(int[] nums) {
        int single=0;
        int dbl=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]/10==0) single+=nums[i];
            else dbl+=nums[i];
        }
        if(single==dbl) return false;
        else return true;
    }
}