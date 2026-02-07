class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') a++;
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                a--;
                ans=Math.min(a+b,ans);
            }
            else{
                ans=Math.min(a+b,ans);
                b++;
            }
        }
        return ans;
    }
}