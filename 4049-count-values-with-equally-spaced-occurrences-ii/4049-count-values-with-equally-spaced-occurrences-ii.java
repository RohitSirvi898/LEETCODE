class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        int specialCount=0;
        for(List<Integer> list : map.values()){
            if(list.size()>2){
                boolean flag = true;
                int space = list.get(1)-list.get(0);
                for(int i=2;i<list.size();i++){
                    if(list.get(i)-list.get(i-1)!=space) flag = false;
                }
                if(flag) specialCount++;
            }
        }
        return specialCount;
    }
}