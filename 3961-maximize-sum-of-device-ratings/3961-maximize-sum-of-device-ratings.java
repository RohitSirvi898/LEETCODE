class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;
        Long sum = 0L;
        if(n==1){
            for(int i=0;i<m;i++){
                sum+=units[i][0];
            }
            return sum;
        }
        int secondSmallest = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<m;i++){
            Arrays.sort(units[i]);
            if(units[i][1]<secondSmallest){
                secondSmallest = units[i][1];
                idx = i;
            }
        }
        int smallest = units[idx][0];
        for(int i=0;i<m;i++){
            if(i!=idx){
                smallest = Math.min(smallest,units[i][0]);
                sum+=units[i][1];
            }
        }
        sum+=smallest;

        return sum;
    }
}