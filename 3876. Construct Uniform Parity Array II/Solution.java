class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        boolean even=false;
        boolean odd=false;
        int smallest = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0) {
                even=true;
            }
            else {
                odd=true;
            }
            smallest = Math.min(smallest,nums1[i]);
        }
        if(odd && even){
            return smallest%2!=0;
        }
        return true;
    }
}