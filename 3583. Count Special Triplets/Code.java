class Solution {
    long mod=1000000007;
    public int specialTriplets(int[] nums) {
     int max=0;
        for(int i=0;i<nums.length;i++){
         max=Math.max(max,nums[i]);
     }
        int pre[]=new int[max+1];
        int suff[]=new int[max+1];
        for(int i=0;i<nums.length;i++){
            pre[nums[i]]++;
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            pre[nums[i]]--;
            int val=nums[i]*2;
            if(val<=max){
            long tt=((long)pre[val]*(long)suff[val])%mod;
            ans=(ans+tt)%mod;
            }
            suff[nums[i]]++;
        }
        return (int)ans;
    }
}