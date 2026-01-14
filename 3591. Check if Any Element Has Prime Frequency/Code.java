class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        Arrays.sort(nums);
        // int i=0;
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int count=1;
            while(j<nums.length && nums[i]==nums[j]) {
                count++; 
                j++;
            }
            i=j-1;
            boolean flag=true;
            for(int k=2;k<count;k++){
                if(count%k==0) flag=false;
            }
            if(flag && count!=1) System.out.print(nums[i]+" ");
        }
        return false;
    }
}