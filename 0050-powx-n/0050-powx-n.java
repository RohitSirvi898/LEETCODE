class Solution {

    public double pow(double x,long n){
        if(n==0) return 1; 
        double halfpow = pow(x,n/2);
        double ans = halfpow*halfpow;
        if(n%2==1){
            ans*=x;
        }
        return ans;
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N<0) {
            N=-N;
            x=1/x;
        }
        return pow(x,N);
    }
}