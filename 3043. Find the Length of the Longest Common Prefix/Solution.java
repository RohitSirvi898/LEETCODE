class Solution {
    public int digits(int x) {
        int cnt = 0;
        while(x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num: arr1){
            int x = num;
            while(x!=0){
                set.add(x);
                x/=10;
            }
        }
        for(int num: arr2){
            int x = num;
            int len = digits(x);
            while(x!=0){
                if(set.contains(x)){
                    ans = Math.max(ans,len);
                    break;
                }
                x/=10;
                len--; 
            }
        }
        return ans;
    }
}