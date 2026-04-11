class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int res = 0;
        for(int i=n-k;i<n;i++){
            sum+=cardPoints[i];
        }
        int j = n-k;
        res = Math.max(res,sum);
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
            sum-=cardPoints[j];
            j++;
            res = Math.max(res,sum);
        }
        return res;
    }
}