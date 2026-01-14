class Solution {
    public int countPrimes(int n) {
        int count=0;
        boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);

        for(int i=2;i*i<n;i++){
            if(prime[i]){
                for(int p=i*i;p<n;p+=i){
                    prime[p]=false;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(prime[i]) count++;
        }

        return count;
    }
}