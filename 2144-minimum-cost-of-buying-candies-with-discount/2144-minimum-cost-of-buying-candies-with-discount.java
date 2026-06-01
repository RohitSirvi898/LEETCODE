class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int sum = 0;
        int count = 2;
        for(int i=n-1;i>=0;i--){
            if(count==0){
                count=2;
                continue;
            }
            sum+=cost[i];
            count--;
        }
        return sum;
    }
}