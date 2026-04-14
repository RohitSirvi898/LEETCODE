class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int[] nums, int k){
         HashMap<Integer,Integer> map = new HashMap<>();
        int j=0;
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[j],map.get(nums[j])-1);
                map.remove(nums[j],0);
                j++;
            }
            count+=i-j+1;
        }
        return count;
    }
}