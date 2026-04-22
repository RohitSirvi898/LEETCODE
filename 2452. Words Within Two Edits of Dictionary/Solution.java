class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int n = queries[0].length();
        for(String str : queries){
            for(String dict : dictionary){
                int count = 2;
                for(int i=0;i<n;i++){
                    if(str.charAt(i)!=dict.charAt(i)) count--;
                    if(count<0) break;
                }
                if(count>=0) {
                    ans.add(str);
                    break;
                }
            }
        }
        return ans;
    }
}