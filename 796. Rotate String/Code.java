class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(goal.length()!=n) return false;
        String ans=s+s;
        return ans.contains(goal);
    }
}