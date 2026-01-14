class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]) {
                index=i;
                break;
            }
        }
        if(index!=-1){
            for(int i=n-1;i>0;i--){
                if(nums[i]>nums[index]){
                    int temp=nums[i];
                    nums[i]=nums[index];
                    nums[index]=temp;
                    break;
                }
            }
        }
        int i=n-1;
        index++;
        while(index<i){
            int temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
            i--;
            index++;
        }

    }
}