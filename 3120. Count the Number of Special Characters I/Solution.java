class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] a = new boolean[26];
        boolean[] A = new boolean[26];

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch-'a'>=0 && ch-'z'<=0) a[ch-'a'] = true;
            else A[ch-'A'] = true;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(a[i] && A[i]) count++;
        }

        return count;
    }
}