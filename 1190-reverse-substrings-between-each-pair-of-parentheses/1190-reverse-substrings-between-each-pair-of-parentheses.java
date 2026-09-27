class Solution {
    public String reverseParentheses(String s) {
        
        return helper(s);
    }
    public String helper(String s){
        int r = s.indexOf(')');
        if(r==-1){
            return s;
        }
        int l = s.lastIndexOf('(',r);
        String left = s.substring(0,l);
        StringBuilder mid = new StringBuilder(s.substring(l+1,r));
        String right = s.substring(r+1);
        return helper(left+mid.reverse().toString()+right);
    }
}