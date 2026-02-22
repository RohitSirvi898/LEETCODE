class Solution {
    public String maximumXor(String s, String t) {
        int n=s.length();
        char tChar[] = t.toCharArray();
        Arrays.sort(tChar);
        int i=0;
        int j=n-1;
        StringBuilder ans= new StringBuilder();
        for(int k=0;k<n;k++){
            if(s.charAt(k)=='1' && i<=j && tChar[i]=='0'){
                ans.append('1');
                i++;
            }
            else if(s.charAt(k)=='0' && i<=j && tChar[j]=='1'){
                ans.append('1');
                j--;
            }
            else{
                ans.append('0');
                i++;
            }
        }
        return ans.toString();
    }
}