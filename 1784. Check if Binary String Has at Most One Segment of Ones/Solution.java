class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' && !flag) return false;
            else if(s.charAt(i)=='0') flag=false;
        }
        return true;
    }
}