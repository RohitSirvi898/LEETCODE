class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int min = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum=Math.min(landStartTime[i]+landDuration[i],sum);
        }
        for(int j=0;j<m;j++){
            if(sum>=waterStartTime[j]){
                min = Math.min(min,sum+waterDuration[j]);
            }
            else{
                min = Math.min(min,waterStartTime[j]+waterDuration[j]);
            }
        }
        sum = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            sum=Math.min(waterStartTime[i]+waterDuration[i],sum);
        }
        for(int j=0;j<n;j++){
            if(sum>=landStartTime[j]){
                min = Math.min(min,sum+landDuration[j]);
            }
            else{
                min = Math.min(min,landStartTime[j]+landDuration[j]);
            }
        }

        return min;

    }
}