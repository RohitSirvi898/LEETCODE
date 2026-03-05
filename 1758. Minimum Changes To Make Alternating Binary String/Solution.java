class Solution {
    public int minOperations(String s) {
        int count = 0;
        char prev = s.charAt(0);
        int n = s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)==prev){
                count++;
            }
            prev=(prev=='0'?'1':'0');
        }
        return Math.min(count,n-count);
    }
}