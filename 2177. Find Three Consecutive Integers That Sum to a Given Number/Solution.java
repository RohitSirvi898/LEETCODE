class Solution {
    public long[] sumOfThree(long num) {
        long l = 0;
        long h = num;
        if(num==0) return new long[]{-1,0,1};

        while(l<h){
            long m = l+(h-l)/2;
            if((3*m) == num ) return new long[]{m-1,m,m+1};
            else if(3*m < num) l=m+1;
            else h=m;
        }
        return new long[0];
    }
}