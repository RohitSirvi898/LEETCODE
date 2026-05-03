class Solution {
    public boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        int x = n;
        int r = 0;
        while(x!=0){
            int digit = x%10;
            r = r*10 + digit;
            x/=10;
        }

        int min = Math.min(r,n);
        int max = Math.max(r,n);
        int sum = 0;
        for(int i=min;i<=max;i++){
            if(isPrime(i)) {
                sum+=i;
            }
        }
        return sum;
    }
}