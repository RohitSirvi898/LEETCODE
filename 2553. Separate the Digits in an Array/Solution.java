class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            while(num>0){
                list.add(num%10);
                num/=10;
            }
        }
        
        int n = list.size();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = list.get(n-i-1);
        }
        return ans;
    }
}