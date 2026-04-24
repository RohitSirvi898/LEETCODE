class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<hand.length;i++){
            minHeap.add(hand[i]);
        }

        while(!minHeap.isEmpty()){
            int prev = minHeap.poll();
            List<Integer> list = new ArrayList<>();
            int n = groupSize-1;
            while(n>0 && !minHeap.isEmpty()){
                int curr = minHeap.poll();
                if(curr == prev) list.add(curr);
                else if(curr>prev+1) return false;
                else {
                    prev = curr;
                    n--;
                }
            }
            if(n!=0) return false;
            for(int i : list){
                minHeap.add(i);
            }
        }

        return true;
    }
}