class Solution {
    public int maximumLength(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(nums[i]==1){
                int len = map.get(1);
                ans = Math.max(ans,(len%2==0)?len-1:len);
            }
            else{
                int len = 0;
                while(map.containsKey(x)){
                    if(map.get(x)==1){
                        len+=1;
                        break;
                    }
                    else if(map.get(x)>1){
                        len+=2;
                        x*=x;
                    }
                    else break;
                }
                ans = Math.max(ans,(len%2==0)?len-1:len);
            }
        }
        return ans;
    }
}