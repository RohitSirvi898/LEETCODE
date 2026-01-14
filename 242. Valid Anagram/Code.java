class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int m1[]=new int[26];
        int m2[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            int c1=s.charAt(i);
            int c2=t.charAt(i);
            m1[c1]++;
            m2[c2]++;
        }

        for(int i=0;i<256;i++){
            if(m1[i]!=m2[i]) return false;
        }
        return true;
    }
}