class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a,b)-> {
            if(a[1]-a[0]==b[1]-b[0]) return Integer.compare(b[1],a[1]);
            else return Integer.compare(b[1]-b[0],a[1]-a[0]);
        });

        int minenergy = Integer.MAX_VALUE;
        int maxenergy = 0;

        for(int i=0;i<n;i++){
            minenergy = Math.min(minenergy, tasks[i][1]);
            maxenergy += tasks[i][1];
        }

        int low = minenergy;
        int high = maxenergy;
        while(low<high){
            int mid = (low+high)/2;
            boolean flag = true;
            int energy = mid;
            for(int i=0;i<n;i++){
                if(energy<tasks[i][1]) {
                    flag = false;
                    break;
                }
                else{
                    energy -= tasks[i][0];
                }
            }
            if(flag) high = mid;
            else low = mid + 1;
        }

        return high;
    }
}