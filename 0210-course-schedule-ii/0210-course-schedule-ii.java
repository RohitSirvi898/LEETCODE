class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] depency = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            depency[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(depency[i]==0) que.offer(i);
        }
        int[] ans = new int[numCourses];
        int idx=0;
        while(!que.isEmpty()){
            int curr = que.poll();
            ans[idx++]=curr;
            for(int i:graph.get(curr)){
                depency[i]--;
                if(depency[i]==0) que.offer(i);
            }
            
        }
        return idx==numCourses?ans:new int[0];
    }
}