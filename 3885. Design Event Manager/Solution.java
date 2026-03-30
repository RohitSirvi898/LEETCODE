class EventManager {
    PriorityQueue<int[]> pq;
    Map<Integer,Integer> actEvt;
    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });

        actEvt = new HashMap<>();

        for(int[] event:events){
            int id = event[0];
            int priority = event[1];
            pq.offer(new int[]{id,priority});
            actEvt.put(id,priority);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        if(actEvt.containsKey(eventId)){
            actEvt.put(eventId,newPriority);
            pq.offer(new int[]{eventId,newPriority});
        }
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int id = curr[0];
            int priority = curr[1];

            if(actEvt.containsKey(id) && actEvt.get(id)==priority){
                actEvt.remove(id);
                return id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */