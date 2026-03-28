class Solution {
    public int countVisiblePeople(int n, int pos, int k) {
        long mod = 1000000007;
        int limit = Math.min(k,n-k-1);
        long num = 1;
        long den = 1;
        for(int i=0;i<limit;i++){
            num = (num*(n-i-1))%mod;
            den = (den*(i+1))%mod;
        }
        long combo = (num*modInv(den,mod-2,mod))%mod;
        long ans = (2*combo)%mod;
        return (int)ans;
    }
    
    public long modInv(long base, long exp, long mod){
        long res = 1;
        base%=mod;
        while(exp>0){
            if(exp%2==1){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            exp/=2;
        }
        return res;
    }
}