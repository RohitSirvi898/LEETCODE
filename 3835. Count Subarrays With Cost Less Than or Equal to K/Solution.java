class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int i=0;
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        long ans=0;
        for(int j=0;j<n;j++){
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()]<=nums[j]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(j);
            while(!minQueue.isEmpty() && nums[minQueue.peekLast()]>=nums[j]){
                minQueue.pollLast();
            }
            minQueue.offerLast(j);
            while(true){
                while(!maxQueue.isEmpty() && maxQueue.peekFirst()<i){
                    maxQueue.pollFirst();
                }
                while(!minQueue.isEmpty() && minQueue.peekFirst()<i){
                    minQueue.pollFirst();
                }
                long max = nums[maxQueue.peekFirst()];
                long min = nums[minQueue.peekFirst()];
                long cost = (max-min)*(j-i+1);
                if(cost<=k) break;
                i++;
            }
            ans+=(j-i+1);
        }
        return ans;
    }
}