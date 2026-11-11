class Solution {
    public long minimumCost(long cost1, long cost2, long costBoth, long need1, long need2) {
        long minNeed = Math.min(need1,need2);
        long way1 = minNeed*(cost1+cost2);
        long way2 = costBoth*minNeed;
        long ans = Math.min(way1,way2);
        need1-=minNeed;
        need2-=minNeed;
        long maxNeed = Math.max(need1,need2);
        ans+= Math.min(costBoth*maxNeed, (need1*cost1 + need2*cost2));
        return ans;
    }
}