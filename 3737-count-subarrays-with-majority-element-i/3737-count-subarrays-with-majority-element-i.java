class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        
        int count=0;
        
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(target,0);
            for(int j=i;j<nums.length;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                if(map.get(target)>(j-i+1)/2) count++;
            }
        }
        return count;
    }
}