class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2!=0) return new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        long n = finalSum;
        long i=2;
        while(n!=0){
            n-=i;
            if(n<=i){
                ans.add(n+i);
                break;
            }
            ans.add(i);
            i+=2;
        }
        return ans;
    }
}