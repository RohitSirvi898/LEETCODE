class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0]=true;
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int j=0;j<size;j++){
                int i = queue.poll();

                if(i==n-1) return step;

                if(i-1>=0 && !visited[i-1]){
                    queue.offer(i-1);
                    visited[i-1] = true;
                }
                if(i+1<n && !visited[i+1]){
                    queue.offer(i+1);
                    visited[i+1] = true;
                }
                if(map.containsKey(arr[i])){
                    for(int num : map.get(arr[i])){
                        if(!visited[num]){
                            queue.offer(num);
                            visited[num] = true;
                        }
                    }
                    map.remove(arr[i]);
                }
            }
            step++;
            
        }
        return -1;
    }
}