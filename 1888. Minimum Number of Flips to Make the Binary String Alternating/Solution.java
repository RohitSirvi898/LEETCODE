class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String S = s+s;
        int res=n;
        int op[] = new int[]{0,0};
        for(int i=0;i<n;i++){
            op[(S.charAt(i)^i)&1]++;
        }
        for(int i=0;i<n;i++){
            op[(S.charAt(i)^i)&1]--;
            op[(S.charAt(i)^(i+n))&1]++;
            res = Math.min(res,Math.min(op[0],op[1]));
        }
        return res;
    }
}