class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int h=0;
        for(int i:nums){
            l=Math.max(l,i);
            h+=i;
        }
        while(l<h){
            int m=l+(h-l)/2;
            int count =1;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if(sum+nums[i]>m){
                    count++;
                    sum=nums[i];
                    if(count>k) break;
                }
                else{
                    sum+=nums[i];
                }
            }
            if(count<=k) h=m;
            else l=m+1;
        }
        return h;
    }
}