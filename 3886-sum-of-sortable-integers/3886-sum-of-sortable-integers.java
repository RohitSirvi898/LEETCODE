class Solution {

    public boolean check(int[] nums, int k){
        int n = nums.length;
        int prev = 0;

        for(int i = 0; i<n; i+=k){
            int min = nums[i];
            int max = nums[i];
            int cnt = 0;
            for(int j=i;j<i+k-1;j++){
                if(nums[j]>nums[j+1]) cnt++;
                min = Math.min(min,nums[j+1]);
                max = Math.max(max,nums[j+1]);
            }

            if(nums[i+k-1]>nums[i]) cnt++;
            if(cnt>1 || prev>min) return false;

            prev = max;
        }

        return true;
    }
    
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int k=1;k*k<=n;k++){
            if(n%k==0){
                if(check(nums,k)) ans+=k;

                int other = n/k;
                if(other!=k && check(nums,other)) ans+=other;
            }
        }

        return ans;
    }
}