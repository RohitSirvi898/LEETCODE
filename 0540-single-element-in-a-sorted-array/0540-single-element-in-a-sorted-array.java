class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        int l=0;
        int h=n-1;
        while(l<h){
            int m = l+(h-l)/2;
            // if(nums[m]!=nums[m-1] && nums[m]!=nums[m+1]) return nums[m];
            if(m%2==0){
                if(m<n-1 && nums[m]!=nums[m+1]) h=m;
                else l=m+1;
            }
            else{
                if(m>0 && nums[m]!=nums[m-1]) h=m;
                else l=m+1;
            }
        }

        return nums[h];
    }
}