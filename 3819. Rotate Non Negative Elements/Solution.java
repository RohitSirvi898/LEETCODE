class Solution {
    public void rotate(List<Integer> list, int l, int h){
        while(l<h){
            int temp = list.get(l);
            list.set(l,list.get(h));
            list.set(h,temp);
            h--;
            l++;
        }
    } 
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>=0) list.add(nums[i]);
        }
        if(list.size()==0) return nums;
        k = k%list.size();
        rotate(list,0,k-1);
        rotate(list,k,list.size()-1);
        rotate(list,0,list.size()-1);
        int idx = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>=0){ 
                nums[i]=list.get(idx); 
                idx++;
            }
        }
        return nums;
    }
}