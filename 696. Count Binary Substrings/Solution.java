class Solution {
    public int countBinarySubstrings(String s) {
        int oldcnt = 0;
        int newcnt = 1;
        int ans=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                ans+=Math.min(oldcnt,newcnt);
                oldcnt=newcnt;
                newcnt=1;
            }
            else{
                newcnt++;
            }
        }
        ans+=Math.min(oldcnt,newcnt);
        return ans;
    }
}