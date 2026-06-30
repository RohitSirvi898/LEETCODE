class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] arr = new int[3];
        int count = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                count+=n-i;
                arr[s.charAt(j)-'a']--;
                j++;
            }
        }
        return count;
    }
}