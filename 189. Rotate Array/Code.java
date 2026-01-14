class Solution {
    public void rotate(int[] arr, int d) {
        int m=d%arr.length;
        int i=0;
        int j=arr.length-m-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        i=arr.length-m;
        j=arr.length-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        i=0;
        j=arr.length-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}