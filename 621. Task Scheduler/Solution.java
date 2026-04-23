class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ans = 0;
        int[] charFreq = new int[26];

        for(int i=0;i<tasks.length;i++){
            charFreq[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

        for(int i=0;i<26;i++){
            if(charFreq[i]>0) maxHeap.add(charFreq[i]);
        }

        while(!maxHeap.isEmpty()){
            int cycle = n+1;

            ArrayList<Integer> list = new ArrayList<>();

            while(cycle>0 && !maxHeap.isEmpty()){

                int currtask = maxHeap.poll();
                if(currtask>1) list.add(currtask-1);
                cycle--;
            }

            for(int i:list){
                maxHeap.add(i);
            }

            ans += maxHeap.isEmpty() ? n-cycle+1 : n + 1;
        }
        return ans;
    }
}