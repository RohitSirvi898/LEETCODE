class Solution {

    public int[] Palindrome(String s, int l, int r){
        int n=s.length();
        while(l>=0 && r<n){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            else break;
        }
        return new int[]{l+1,r-1};
    }

    public String longestPalindrome(String s) {
        int ans[]=new int[2];
        int a=0;
        int b=0;
        for(int i=0;i<s.length();i++){
            int brr[]=Palindrome(s,i,i+1);
            int arr[]=Palindrome(s,i,i);
            System.out.println(Arrays.toString(ans));
            if(arr[1]-arr[0]>ans[1]-ans[0]){
                ans[0]=arr[0];
                ans[1]=arr[1];
            }
            if(brr[1]-brr[0]>ans[1]-ans[0]){
                ans[0]=brr[0];
                ans[1]=brr[1];
            }
        }
        return s.substring(ans[0],ans[1]+1);
    }
}