class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int i : arr1){
            boolean flag = true;
            for(int j : arr2){
                if(Math.abs(i-j)<=d) {
                    flag = false; 
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}