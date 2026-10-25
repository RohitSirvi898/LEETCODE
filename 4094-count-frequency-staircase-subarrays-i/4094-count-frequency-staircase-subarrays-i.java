class Solution {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i=0;i<n;i++){
            Map<Integer,Integer> freq = new HashMap<>();
            List<Integer> order = new ArrayList<>();

            for(int j=i;j<n;j++){
                int val = nums[j];

                if(!freq.containsKey(val)) order.add(val);
                freq.put(val,freq.getOrDefault(val,0)+1);

                boolean isValid = true;

                for(int k=0;k<order.size();k++){
                    int expfreq = k+1;
                    if(freq.get(order.get(k))!=expfreq){
                        isValid=false;
                        break;
                    }
                }

                if(isValid) ans++;
            }
        }
        return ans;
    }
}