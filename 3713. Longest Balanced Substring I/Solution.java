class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int arr[] = new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                boolean flag=true;
                int count = arr[s.charAt(j)-'a'];
                for(int k=0;k<26;k++){
                    if(arr[k]!=0 && arr[k]!=count) flag=false;
                }
                if(flag){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}