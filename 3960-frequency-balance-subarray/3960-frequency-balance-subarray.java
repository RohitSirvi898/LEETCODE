class Solution {
    
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int u = 0;
        int[] cNums = new int[n];
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], u++);
            }
            cNums[i] = map.get(nums[i]);
        }
        int[] dremovical = nums; 
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[u];            
            int[] freqCount = new int[n + 1];   
            int maxFreq = 0;
            int distinctCount = 0;
            
            for (int j = i; j < n; j++) {
                int x = cNums[j];
                int oldF = freq[x];
                
                if (oldF == 0) {
                    distinctCount++;
                } else {
                    freqCount[oldF]--;
                }
                
                int newF = oldF + 1;
                freq[x] = newF;
                freqCount[newF]++;
                
                if (newF > maxFreq) {
                    maxFreq = newF;
                }
                
                boolean isValid = false;
                
                if (distinctCount == 1) {
                    isValid = true;
                } 
                else if (maxFreq % 2 == 0) {
                    int half = maxFreq / 2;
                    if (freqCount[maxFreq] > 0 && freqCount[half] > 0 && 
                        (freqCount[maxFreq] + freqCount[half] == distinctCount)) {
                        isValid = true;
                    }
                }
                
                if (isValid) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        
        return ans;
    }
}