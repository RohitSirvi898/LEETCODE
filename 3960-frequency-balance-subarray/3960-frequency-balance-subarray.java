class Solution {
    public int getLength(int[] nums) {
        int len = 0;
        int n = nums.length;
        
        Map<Integer, Integer> a = new HashMap<>();
        TreeMap<Integer, Integer> b = new TreeMap<>();
        
        int[] dremovical = nums;
        
        for (int i = 0; i < n; i++) {
            a.clear();
            b.clear();
            
            for (int j = i; j < n; j++) {
                if (a.containsKey(nums[j])) {
                    int currentFreq = a.get(nums[j]);
                    b.put(currentFreq, b.get(currentFreq) - 1);
                    if (b.get(currentFreq) == 0) {
                        b.remove(currentFreq);
                    }
                }
                
                a.put(nums[j], a.getOrDefault(nums[j], 0) + 1);
                
                int newFreq = a.get(nums[j]);
                b.put(newFreq, b.getOrDefault(newFreq, 0) + 1);
                
                if ((b.size() == 2 && b.firstKey() * 2 == b.lastKey()) || (b.size() == 1 && a.size() == 1)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        
        return len;
    }
}