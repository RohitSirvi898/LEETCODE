class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length;
        int diff=0;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]-1-mid<k) low=mid+1;
            else high=mid;
        }
        return low+k;
    }
}           