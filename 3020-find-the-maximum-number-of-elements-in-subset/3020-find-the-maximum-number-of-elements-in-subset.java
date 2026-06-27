class Solution {
    public int maximumLength(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.containsKey(1)){
            int len = map.get(1);
            ans = (len%2==0)?len-1:len;
            map.remove(1);
        }
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            int len = 0;
            while(map.containsKey(x) && map.get(x)>1){
                len+=2;
                x*=x;
            }
            ans = Math.max(ans,len+(map.containsKey(x)?1:-1));
        }
        return ans;
    }
}