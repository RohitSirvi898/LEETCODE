class Solution {
    public int passwordStrength(String password) {
        int n = password.length();
        boolean a[] = new boolean[26];
        boolean A[] = new boolean[26];
        boolean num[] = new boolean[10];
        boolean s1=false,s2=false,s3=false,s4=false;

        for(int i=0;i<n;i++){
            char ch = password.charAt(i);
            if(ch-'a'>=0 && ch-'z'<=0) a[ch-'a'] = true;
            else if(ch-'A'>=0 && ch-'Z'<=0) A[ch-'A'] = true;
            else if(ch-'0'>=0 && ch-'9'<=0) num[ch-'0'] = true;
            else if(ch == '!') s1=true;
            else if(ch == '@') s2=true;
            else if(ch == '#') s3=true;
            else if(ch == '$') s4=true;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(a[i]) count+=1;
            if(A[i]) count+=2;
            if(i<10 && num[i]) count+=3;
        }
        if(s1) count+=5;
        if(s2) count+=5;
        if(s3) count+=5;
        if(s4) count+=5;

        return count;
    }
}