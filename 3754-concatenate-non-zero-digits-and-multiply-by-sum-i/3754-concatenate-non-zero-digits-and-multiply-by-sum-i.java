class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        int i = 1;
        while(n!=0){
            int digit = n%10;
            n/=10;
            if(digit==0) continue;
            sum+=digit;
            x=(digit*i)+x;
            i*=10;
        }
        
        return sum*x;
    }
}