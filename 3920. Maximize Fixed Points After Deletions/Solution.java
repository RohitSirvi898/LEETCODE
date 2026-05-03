class Solution {
    public int maxFixedPoints(int[] nums) {
        List<int[]> pairs = new ArrayList<>();

        for(int i = 0; i<nums.length;i++){
            int val = nums[i];
            int reqDel = i-val;

            if(reqDel >= 0) pairs.add(new int[]{val, reqDel});
        }

        pairs.sort((a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });

        List<Integer> dp = new ArrayList<>();

        for(int[] p : pairs){
            int d = p[1];

            int left = 0;
            int right = dp.size()-1;
            int pos = dp.size();

            while(left<=right){
                int mid = left + (right - left) / 2;
                if (dp.get(mid)>d){
                    pos = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            if(pos == dp.size()) dp.add(d);
            else dp.set(pos,d);
        }

        return dp.size();
    }
}