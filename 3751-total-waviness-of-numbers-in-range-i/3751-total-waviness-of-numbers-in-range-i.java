class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;

        for(int i=num1;i<=num2;i++){
            int num = i;
            int prev = num%10;
            num/=10;
            int curr = num%10;
            num/=10;
            while(num!=0){
                int next = num%10;
                num/=10;
                if((curr<next && curr<prev) || (curr>next && curr>prev)) count++;
                prev = curr;
                curr = next;
            }
        }
        return count;
    }
}