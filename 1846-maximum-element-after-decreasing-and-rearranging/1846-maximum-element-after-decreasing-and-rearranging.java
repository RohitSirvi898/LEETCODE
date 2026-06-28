class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>prev+1){
                prev+=1;
            }
            else prev = arr[i];
        }
        return prev;
    }
}