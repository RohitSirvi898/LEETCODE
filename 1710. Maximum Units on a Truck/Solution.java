class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int ans = 0;
        int remsize = truckSize;
        for(int[] boxType:boxTypes){
            if(boxType[0]<remsize) {
                ans += boxType[0]*boxType[1];
                remsize-=boxType[0];
            }
            else {
                ans += remsize*boxType[1];
                return ans;
            }
        }
        return ans;
    }
}