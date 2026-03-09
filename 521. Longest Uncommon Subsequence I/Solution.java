class Solution {
    public int findLUSlength(String a, String b) {
        int index = -1;
        int n= Math.min(a.length(),b.length());
        for(int i=0;i<n;i++){
            if(a.charAt(i)!=b.charAt(i)) {
                index = i;
                break;
            }
        }
        return (index==-1 && a.length()==b.length())?-1:Math.max(a.length(),b.length());
    }
}