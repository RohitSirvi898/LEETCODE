class Solution {
    public int binaryGap(int n) {
        int count=0;
        int max=0;
        while(n%2!=1) n=n>>1;
        while(n!=0){
            if(n%2==1){
                max=Math.max(count,max);
                count=0;
            }
            n=n>>1;
            count++;
        }
        return max;
    }
}