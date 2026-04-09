class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int res = 0;
        int maxfreq = 0;
        int i = 0;
        for(int j=0;j<s.length();j++){
            freq[s.charAt(j)-'A']++;
            maxfreq = Math.max(maxfreq,freq[s.charAt(j)-'A']);

            while((j-i+1) - maxfreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}