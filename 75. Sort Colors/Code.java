class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zero++;
            else if(nums[i]==1) one++;
        }
        while(zero>0){
            nums[j]=0;
            zero--;
            j++;
        }
        while(one>0){
            nums[j]=1;
            one--;
            j++;
        }
        while(j<nums.length){
            nums[j]=2;
            j++;
        }
    }
}