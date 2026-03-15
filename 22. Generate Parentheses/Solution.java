class Solution {
    private void helper(List<String> list,StringBuilder str, int n,int m){
        if(n==0 && m==0) {
            list.add(str.toString());
        }
       if(n>0) {
        str.append("(");
        helper(list,str,n-1,m);
        str.setLength(str.length()-1);
       }
       if(m>n) {
        str.append(")");
        helper(list,str,n,m-1);
        str.setLength(str.length()-1);
       }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(list,str,n,n);
        return list;
    }
}