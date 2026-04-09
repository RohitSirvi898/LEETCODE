class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] abc = new int[3];
        int count = 0;
        int j = 0;
        for (int i=0;i<n;i++){
            abc[s.charAt(i)-'a']++;
            while(abc[0]>0 && abc[1]>0 && abc[2]>0){
                count+=n-i;
                abc[s.charAt(j)-'a']--;
                j++;
            }
        }
        return count;
    }
}