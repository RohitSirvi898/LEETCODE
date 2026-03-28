class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            max = Math.max(nums[i],max);
            while(!dq.isEmpty() && dq.getLast()<nums[i]){
                dq.pollLast();
            }
            dq.offer(nums[i]);
        }
        int[] ans = new int[n-k+1];
        ans[0]=dq.getFirst();
        for(int i=k;i<n;i++){
            if(nums[i-k] == dq.getFirst()) dq.pollFirst();
            while(!dq.isEmpty() && dq.getLast()<nums[i]){
                dq.pollLast();
            }
            dq.offer(nums[i]);
            ans[i-k+1]=dq.getFirst();
        }
        return ans;
    }
}