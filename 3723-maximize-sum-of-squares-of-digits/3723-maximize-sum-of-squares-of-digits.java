class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<num;i++){
            if(sum>9){
                sum-=9;
                ans.append('9');
            }
            else{
                ans.append((char)(sum + '0'));
                sum = 0;
            }
        }

        if(sum!=0) return "";
        return ans.toString();
    }
}