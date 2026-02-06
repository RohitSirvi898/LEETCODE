class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=i;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        while(i<n){
            while(j<n && (long)nums[j]<=(long)k*nums[i]){
                ans=Math.min(ans,n-(j-i+1));
                j++;
            }
            i++;
            
        }
        return ans;
    }
}