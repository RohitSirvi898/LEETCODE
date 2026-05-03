class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefRight = new int[n];
        int[] prefLeft = new int[n];

        for(int i=0;i<n;i++){
            int closest = -1;

            if(i==0) closest=1;
            else if(i==n-1) closest = n-2;
            else{
                int diffLeft = nums[i]-nums[i-1];
                int diffRight = nums[i+1]-nums[i];
                if(diffLeft <= diffRight) closest = i-1;
                else closest = i+1;
            }

            if(i<n-1){
                int costRight = (closest == i+1)? 1 : (nums[i+1]-nums[i]);
                prefRight[i+1] = prefRight[i] + costRight;
            }
            if(i>0){
                int costLeft = (closest == i-1)? 1 : (nums[i]-nums[i-1]);
                prefLeft[i] = prefLeft[i-1] + costLeft;
            }
        }

        int[] ans = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];

            if(u<v) ans[i] = prefRight[v]-prefRight[u];
            else if(u>v) ans[i] = prefLeft[u]-prefLeft[v];
            else ans[i] = 0;
        }

        return ans;
    }
}