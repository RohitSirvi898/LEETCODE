class Solution {
    public int numberOfSpecialChars(String word) {
        int[] a = new int[26];
        int[] A = new int[26];
        Arrays.fill(a,-1);
        Arrays.fill(A,-1);

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch-'a'>=0) a[ch-'a'] = i;
            else{
                if(A[ch-'A']==-1) A[ch-'A'] = i ;
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(a[i]!=-1 && a[i]<A[i]) count++;
        }

        return count;
    }
}