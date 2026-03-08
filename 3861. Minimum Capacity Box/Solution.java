class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minIndex = -1;
        int ans = -1;
        for(int i=0;i<capacity.length;i++){
            if(capacity[i]>=itemSize && (minIndex==-1 || capacity[i]<capacity[minIndex])){
                minIndex=i;
            }
        }
        return minIndex;
    }
}