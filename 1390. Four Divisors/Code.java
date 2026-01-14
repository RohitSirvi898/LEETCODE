class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int num:nums){
            int count=0;
            int sum=0;
            int n=(int)Math.sqrt(num);
            for(int i=1;i<=n;i++){
                
                if(num%i==0){
                    sum+=i;
                    count++;
                    if(i*i!=num){
                        sum+=num/i;
                        count++;
                    }
                }
                if (count > 4) break;
            }
            if(count==4) ans+=sum;
        }
        return ans;
    }
}