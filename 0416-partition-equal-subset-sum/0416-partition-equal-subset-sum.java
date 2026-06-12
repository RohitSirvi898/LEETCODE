class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] possible = new boolean[target+1];
        possible[0]=true;
        for(int num:nums){
            for(int i=target;i>=0;i--){
                if(possible[i] && i+num<=target) possible[i+num] = true;
            }
        }

        return possible[target];
    }
}