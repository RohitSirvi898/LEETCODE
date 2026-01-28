class Solution {
    public int countGoodNumbers(long n) {
        long evenposition = (n+1)/2;
        long oddposition = (n)/2;
        long evenway = fastpower(5,evenposition);
        long oddway = fastpower(4,oddposition);

        return (int)((evenway*oddway)%1000000007);
    }

    public long fastpower(long base, long power){
        long result = 1;
        base%=1000000007;

        while(power>0){
            if(power%2==1) result = (result*base)%1000000007;
            base = (base*base)%1000000007;
            power/=2;
        }
        return result;
    }
}