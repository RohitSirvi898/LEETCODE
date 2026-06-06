class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                for(int j:map.get(nums[i])){
                    if(Math.abs(i-j)<=k) return true;
                }
            }
            else map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        return false;
    }
}