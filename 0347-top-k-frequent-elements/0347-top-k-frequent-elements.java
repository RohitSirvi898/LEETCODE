class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int num = -1;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(num!=nums[i]){
                pq.offer(new int[]{num,count});
                num = nums[i];
                count=1;
            }
            else{
                count++;
            }
        }
        pq.offer(new int[]{num,count});
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}