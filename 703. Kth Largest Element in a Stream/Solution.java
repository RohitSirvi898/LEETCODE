class KthLargest {
    PriorityQueue<Integer> ans;
    int k;
    public KthLargest(int k, int[] nums) {
        ans = new PriorityQueue<>(k);
        this.k = k;
        for(int num:nums){
            if(ans.size()<k) ans.offer(num);
            else if(num>ans.peek()){
                ans.offer(num);
                ans.poll();
            }
        }
    }
    
    public int add(int val) {
        if(ans.size()<k) ans.offer(val);
        else if(val>ans.peek()){
            ans.offer(val);
            ans.poll();
        }
        return ans.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */