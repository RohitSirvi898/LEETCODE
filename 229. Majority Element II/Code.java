class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int num1=0;
        int num2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && num2!=nums[i]){
                count1=1;
                num1=nums[i];
            }
            else if(count2==0 && num1!=nums[i]){
                count2=1;
                num2=nums[i];
            }
            else if(num1==nums[i]) count1++;
            else if(num2==nums[i]) count2++;
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> arr = new ArrayList<>();
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(num1==nums[i]) count1++;
            else if(num2==nums[i]) count2++;
        }
        int target=nums.length/3;
        if(count1>target) arr.add(num1);
        if(count2>target) arr.add(num2);
        return arr;
    }
}