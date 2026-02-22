class Solution {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        int count=0;
        int player1=0;
        int player2=0;
        boolean flag=true;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                flag = !flag;
            }
            if(count==5){
                flag = !flag;
            }
            if(flag){
                player1+=nums[i];
            }
            else player2+=nums[i];
            count=(count+1)%6;
        }
        return player1-player2;
    }
}