class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        int specialCount = 0;
        for(List<Integer> idx : map.values()){
            if(idx.size()==3){
                int i1 = idx.get(0);
                int i2 = idx.get(1);
                int i3 = idx.get(2);

                if(i2-i1==i3-i2) specialCount++;
            }
        }

        return specialCount;
    }
}